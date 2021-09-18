package com.rpc.example.core;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @Package: com.rpc.example.core
 * @ClassName: Header
 * @Author: zyh
 * @CreateTime: 2021/9/17 10:14 下午
 * @Description:
 */
@AllArgsConstructor
@Data
public class Header implements Serializable {

    private short magic;//魔数 2字节
    private byte serialType;//序列化类型
    private byte reqType;//消息类型 1字节
    private long requestId;//消息id 8字节
    private int length;//消息体长度 4字节
}
