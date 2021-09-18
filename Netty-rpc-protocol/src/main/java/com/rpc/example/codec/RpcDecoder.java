package com.rpc.example.codec;

import com.rpc.example.constants.ReqType;
import com.rpc.example.constants.RpcConstant;
import com.rpc.example.core.Header;
import com.rpc.example.core.RpcProtocol;
import com.rpc.example.core.RpcRequest;
import com.rpc.example.core.RpcResponse;
import com.rpc.example.serial.ISerializer;
import com.rpc.example.serial.SerializerManager;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.serializer.Serializer;

import java.util.List;

/**
 * @Package: com.rpc.example.codec
 * @ClassName: RpcDecoder
 * @Author: zyh
 * @CreateTime: 2021/9/18 9:29 上午
 * @Description:
 */
@Slf4j
public class RpcDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        log.info("=============begin RpcDecoder ===============");

        if (in.readableBytes()< RpcConstant.HEAD_TOTAL_LEN){
            return;
        }

        in.markReaderIndex();//标记读取开始的索引
        short maci = in.readShort();//读取两个字节的magic
        if (maci != RpcConstant.MAGIC){
            throw new IllegalArgumentException("Illegal request parameter 'magic',"+maci);
        }


        byte serialType = in.readByte();//读取一个字节的序列化类型
        byte reqType = in.readByte();//读取一个字节的消息类型
        long requestId = in.readLong();//读取请求id
        int dataLength = in.readInt();//读取四个字节 消息体长度

        if (in.readableBytes()<dataLength){
            in.resetReaderIndex();//如果剩余可读 小于数据长度，就说明报文格式不对。
            return;
        }

        //读取消息体
        byte[] content = new byte[dataLength];
        in.readBytes(content);

        Header header = new Header(maci,serialType,reqType,requestId,dataLength);
        ISerializer serializer = SerializerManager.getSerializer(serialType);
        ReqType rt = ReqType.findByCode(reqType);
        switch (rt){
            case REQUEST:
                RpcRequest request = serializer.deserialize(content,RpcRequest.class);
                RpcProtocol<RpcRequest> reqProtocol = new RpcProtocol<>();
                reqProtocol.setHeader(header);
                reqProtocol.setContent(request);
                out.add(reqProtocol);
                break;
            case RESPONSE:
                RpcResponse response = serializer.deserialize(content,RpcResponse.class);
                RpcProtocol<RpcResponse> resProtocol = new RpcProtocol<>();
                resProtocol.setHeader(header);
                resProtocol.setContent(response);
                out.add(resProtocol);
                break;
            case HEARTBEAT:
                //todo
                break;
            default:
                //todo
                break;
        }
    }
}
