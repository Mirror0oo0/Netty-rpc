package com.rpc.example.handler;

import com.rpc.example.core.RequestHolder;
import com.rpc.example.core.RpcFuture;
import com.rpc.example.core.RpcProtocol;
import com.rpc.example.core.RpcResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @Package: com.rpc.example.handler
 * @ClassName: RpcClientHandler
 * @Author: zyh
 * @CreateTime: 2021/9/18 7:31 下午
 * @Description:
 */
@Slf4j
public class RpcClientHandler extends SimpleChannelInboundHandler<RpcProtocol<RpcResponse>> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcProtocol<RpcResponse> msg) throws Exception {
        log.info("receive Rpc Server Result");
        long requestId=msg.getHeader().getRequestId();
        RpcFuture<RpcResponse> future= RequestHolder.REQUEST_MAP.remove(requestId);
        future.getPromise().setSuccess(msg.getContent()) ; //返回结果
    }
}