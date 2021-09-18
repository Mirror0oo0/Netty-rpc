package com.rpc.example.core;

import lombok.Data;

import java.io.Serializable;

/**
 * @Package: com.rpc.example.core
 * @ClassName: RpcResponse
 * @Author: zyh
 * @CreateTime: 2021/9/17 10:21 下午
 * @Description:
 */
@Data
public class RpcResponse implements Serializable {
    private Object data;
    private String msg;
}
