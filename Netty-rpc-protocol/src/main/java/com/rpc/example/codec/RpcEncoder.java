package com.rpc.example.codec;

import com.rpc.example.core.Header;
import com.rpc.example.core.RpcProtocol;
import com.rpc.example.serial.ISerializer;
import com.rpc.example.serial.SerializerManager;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import lombok.extern.slf4j.Slf4j;

/**
 * @Package: com.rpc.example.codec
 * @ClassName: RpcEncoder
 * @Author: zyh
 * @CreateTime: 2021/9/18 10:13 上午
 * @Description:
 */
@Slf4j
public class RpcEncoder extends MessageToByteEncoder<RpcProtocol<Object>>{

    @Override
    protected void encode(ChannelHandlerContext ctx, RpcProtocol<Object> msg, ByteBuf out) throws Exception {
        log.info("==============begin RpcEncoder===========");
        Header header = msg.getHeader();
        out.writeShort(header.getMagic());
        out.writeByte(header.getSerialType());
        out.writeByte(header.getReqType());
        out.writeLong(header.getRequestId());
        ISerializer serializer = SerializerManager.getSerializer(header.getSerialType());
        byte[] data = serializer.serialize(msg.getContent());
        out.writeInt(data.length);
        out.writeBytes(data);
    }
}
