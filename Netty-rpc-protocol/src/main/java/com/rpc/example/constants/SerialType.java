package com.rpc.example.constants;

/**
 * @Package: com.rpc.example.constants
 * @ClassName: SerialType
 * @Author: zyh
 * @CreateTime: 2021/9/17 10:25 下午
 * @Description:
 */
public enum SerialType {
    JSON((byte) 1),
    JAVA((byte) 2);


    private byte code;
    SerialType(byte code){
        this.code = code;
    }

    public byte code(){
        return this.code;
    }
}
