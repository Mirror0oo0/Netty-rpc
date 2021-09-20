package com.rpc.example.spring.service;

import com.rpc.example.annotation.RemoteService;
import com.rpc.example.protocol.NettyServer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Package: com.rpc.example.spring.service
 * @ClassName: SpringRpcProviderBean
 * @Author: zyh
 * @CreateTime: 2021/9/20 11:14 上午
 * @Description:
 */
@Slf4j
@Data

//实现两个接口，InitializingBean是实现初始化到时候调用，BeanPostProcessor是在初始化之前和初始化之后会各有两个方法进行回调
public class SpringRpcProviderBean implements InitializingBean, BeanPostProcessor {

    private final int serverPort;
    private final String serverAddress;

    public SpringRpcProviderBean(int serverPort) throws UnknownHostException {
        this.serverPort = serverPort;
        InetAddress address = InetAddress.getLocalHost();
        this.serverAddress = address.getHostAddress();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("begin deploy Netty Server to host {},on port {}",this.serverAddress,this.serverPort);
        new Thread(
                ()->{
                    new NettyServer(this.serverAddress,this.serverPort).startNettyServer();
                }
        ).start();
    }

    //在初始化后回调到函数，BeanPostProcessor接口是作用在一个容器中的全部bean。
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //只要bean声明了RemoteService注解，则需要把该服务发布到网络上。
        if(bean.getClass().isAnnotationPresent(RemoteService.class)){
            Method[] methods = bean.getClass().getDeclaredMethods();
            for (Method method:methods){
                String key = bean.getClass().getInterfaces()[0].getName()+"."+method.getName();
                BeanMethod beanMethod = new BeanMethod();
                beanMethod.setBean(bean);
                beanMethod.setMethod(method);
                Mediator.beanMethodMap.put(key,beanMethod);
            }
        }
        return null;
    }
}
