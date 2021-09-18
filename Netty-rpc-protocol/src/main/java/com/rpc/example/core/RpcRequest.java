package com.rpc.example.core;

import lombok.Data;

import java.io.Serializable;

/**
 * @Package: com.rpc.example.core
 * @ClassName: RpcRequest
 * @Author: zyh
 * @CreateTime: 2021/9/17 10:19 下午
 * @Description:
 */
@Data
public class RpcRequest implements Serializable {

    private String className;//类名字
    private String methodName;//方法名字
    private Object[] params;//请求参数
    private Class<?>[] paramsterTypes;//请求参数类型
}
