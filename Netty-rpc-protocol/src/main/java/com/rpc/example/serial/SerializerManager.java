package com.rpc.example.serial;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Package: com.rpc.example.serial
 * @ClassName: SerializerManager
 * @Author: zyh
 * @CreateTime: 2021/9/17 10:53 下午
 * @Description:
 */
public class SerializerManager {
    private final static ConcurrentHashMap<Byte,ISerializer> serializer = new ConcurrentHashMap<>();

    static{
        ISerializer json = new JsonSerializer();
        ISerializer java = new JavaSerializer();
        serializer.put(json.getType(),json);
        serializer.put(java.getType(),java);
    }

    public static ISerializer getSerializer(byte key){
        ISerializer iSerializer = serializer.get(key);
        if (serializer == null){
            return new JavaSerializer();
        }
        return iSerializer;
    }
}
