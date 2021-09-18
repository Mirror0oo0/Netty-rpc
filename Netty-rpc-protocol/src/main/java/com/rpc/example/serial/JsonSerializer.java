package com.rpc.example.serial;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rpc.example.constants.SerialType;

/**
 * @Package: com.rpc.example.serial
 * @ClassName: JsonSerializer
 * @Author: zyh
 * @CreateTime: 2021/9/17 10:45 下午
 * @Description:
 */
public class JsonSerializer implements ISerializer{
    @Override
    public <T> byte[] serialize(T obj) {
        return JSON.toJSONString(obj).getBytes();
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        return (T) JSONObject.parseObject(new String(data),clazz);
    }

    @Override
    public byte getType() {
        return SerialType.JSON.code();
    }
}
