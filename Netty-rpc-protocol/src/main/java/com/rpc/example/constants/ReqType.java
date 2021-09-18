package com.rpc.example.constants;

import lombok.Data;

/**
 * @Package: com.rpc.example.constants
 * @ClassName: ReqType
 * @Author: zyh
 * @CreateTime: 2021/9/17 10:24 下午
 * @Description:
 */
public enum ReqType {
    REQUEST((byte) 1),
    RESPONSE((byte) 2),
    HEARTBEAT((byte) 3);


    private byte code;
    ReqType(byte code){
        this.code = code;
    }

    public byte code(){
        return this.code;
    }

    public static ReqType findByCode(byte code){
        for (com.rpc.example.constants.ReqType reqType: com.rpc.example.constants.ReqType.values()){
            if (reqType.code == code){
                return reqType;
            }
        }
        return null;
    }
}
