package com.rpc.example.core;

import lombok.Data;

import java.io.Serializable;

/**
 * @Package: com.rpc.example.core
 * @ClassName: RpcProtocol
 * @Author: zyh
 * @CreateTime: 2021/9/17 10:23 下午
 * @Description:
 */
@Data
public class RpcProtocol <T> implements Serializable {
    private Header header;
    private T content;
}
