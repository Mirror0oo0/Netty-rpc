package com.rpc.example.serial;

/**
 * @Package: com.rpc.example.serial
 * @ClassName: Iserializer
 * @Author: zyh
 * @CreateTime: 2021/9/17 10:41 下午
 * @Description:
 */
public interface ISerializer {

    /*
    * 序列化
    * */
    <T> byte[] serialize(T obj);

    /*
    * 反序列化
    * */
    <T> T deserialize(byte[] date,Class<T> clazz);

    /*
    * 序列化类型
    * */
    byte getType();
}
