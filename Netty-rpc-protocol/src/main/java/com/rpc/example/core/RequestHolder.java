package com.rpc.example.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Package: com.rpc.example.core
 * @ClassName: RequestHolder
 * @Author: zyh
 * @CreateTime: 2021/9/18 7:07 下午
 * @Description:
 */
public class RequestHolder  {
    public static final AtomicLong REQUEST_ID = new AtomicLong();

    public static final Map<Long,RpcFuture> REQUEST_MAP = new ConcurrentHashMap<>();
}
