package com.rpc.example.spring.service;

import lombok.Data;

import java.lang.reflect.Method;

/**
 * @Package: com.rpc.example.service
 * @ClassName: BeanMethod
 * @Author: zyh
 * @CreateTime: 2021/9/20 2:34 下午
 * @Description:
 */
@Data
public class BeanMethod {

    private Object bean;
    private Method method;

}
