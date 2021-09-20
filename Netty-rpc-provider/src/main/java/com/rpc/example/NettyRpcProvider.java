package com.rpc.example;

import com.rpc.example.protocol.NettyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Component;

/**
 * @Package: com.rpc.example.service
 * @ClassName: NettyRpcProvider
 * @Author: zyh
 * @CreateTime: 2021/9/17 10:05 下午
 * @Description:
 */
@ComponentScan(basePackages = {"com.rpc.example.spring.service","com.rpc.example.service"})
@SpringBootApplication
public class NettyRpcProvider {
    public static void main(String[] args) {
        SpringApplication.run(NettyRpcProvider.class,args);
        //new NettyServer("127.0.0.1",8080).startNettyServer();//原来是基于此做一个发布
    }
}
