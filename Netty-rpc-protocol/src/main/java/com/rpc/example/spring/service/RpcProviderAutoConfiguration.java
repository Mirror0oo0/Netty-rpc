package com.rpc.example.spring.service;

import com.rpc.example.spring.service.RpcServerProperties;
import com.rpc.example.spring.service.SpringRpcProviderBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.UnknownHostException;

/**
 * @Package: com.rpc.example.service
 * @ClassName: RpcProviderAutoConfiguration
 * @Author: zyh
 * @CreateTime: 2021/9/20 3:15 下午
 * @Description:
 */
//定义一个自动配置类，在这个类。@Bean初始化的时候会去实例化一个SpringRpcProviderBean，这个实例化就会去启动NettyServer。将接口发布到网络上。
@Configuration
@EnableConfigurationProperties(RpcServerProperties.class)
public class RpcProviderAutoConfiguration {

    @Bean
    public SpringRpcProviderBean springRpcProviderBean(RpcServerProperties rpcServerProperties) throws UnknownHostException {
        return new SpringRpcProviderBean(rpcServerProperties.getServicePort());
    }
}
