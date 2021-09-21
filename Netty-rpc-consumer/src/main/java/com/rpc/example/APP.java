package com.rpc.example;

/**
 * @Package: com.rpc.example
 * @ClassName: APP
 * @Author: zyh
 * @CreateTime: 2021/9/17 10:03 下午
 * @Description:
 */
public class APP {
    public static void main(String[] args) {

        RpcClientProxy rpc = new RpcClientProxy();
        IUserService userService = rpc.clientProxy(IUserService.class,"127.0.0.1",20880);
        System.out.println(userService.saveUser("ZYH"));
    }
}
