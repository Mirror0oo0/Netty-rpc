package com.rpc.example.protocol;

import com.rpc.example.core.RpcProtocol;
import com.rpc.example.core.RpcRequest;
import com.rpc.example.handler.RpcClientInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * @Package: com.rpc.example.protocol
 * @ClassName: NettyClient
 * @Author: zyh
 * @CreateTime: 2021/9/18 7:10 下午
 * @Description:
 */
@Slf4j
public class NettyClient {

    private final Bootstrap bootstrap;
    private final EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
    private String serviceAddress;
    private int servicePort;

    public NettyClient(String serviceAddress,int servicePort){
        log.info("begin init Netty Client,{},{}",serviceAddress,servicePort );
        bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGroup)
                .channel(NioSocketChannel.class)
                .handler(new RpcClientInitializer());
        this.serviceAddress = serviceAddress;
        this.servicePort = servicePort;
    }

    public void sendRequest(RpcProtocol<RpcRequest> protocol) throws InterruptedException {
        final ChannelFuture future = bootstrap.connect(this.serviceAddress,this.servicePort).sync();

        future.addListener(listener->{
            if (future.isSuccess()){
                log.info("connect rpc server {} success.",this.serviceAddress);
            }else{
                log.error("connect rpc server {} failed.",this.serviceAddress);
                future.cause().printStackTrace();
                eventLoopGroup.shutdownGracefully();
            }
        });
        log.info("begin transfer data");
        future.channel().writeAndFlush(protocol);
    }
}
