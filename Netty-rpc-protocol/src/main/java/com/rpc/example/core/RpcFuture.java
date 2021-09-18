package com.rpc.example.core;

import io.netty.util.concurrent.Promise;
import lombok.Data;

/**
 * @Package: com.rpc.example.core
 * @ClassName: RpcFuture
 * @Author: zyh
 * @CreateTime: 2021/9/18 7:23 下午
 * @Description:
 */
@Data
public class RpcFuture<T> {

    private Promise<T> promise;

    public RpcFuture(Promise<T> promise){
        this.promise = promise;
    }
}
