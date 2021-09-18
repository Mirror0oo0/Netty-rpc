package com.rpc.example;

import java.lang.reflect.Proxy;

/**
 * @Package: com.rpc.example
 * @ClassName: RpcClientProxy
 * @Author: zyh
 * @CreateTime: 2021/9/18 6:53 下午
 * @Description:
 */
public class RpcClientProxy {
    public  <T> T clientProxy(final Class<T> interfaceCls,final String host,int port){
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(),
                new Class<?>[]{interfaceCls},new RpcInovkerProxy(host,port));
    }
}
