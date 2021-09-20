package com.rpc.example.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Package: com.rpc.example.annotation
 * @ClassName: RemoteService
 * @Author: zyh
 * @CreateTime: 2021/9/20 11:01 上午
 * @Description:
 */
@Target(ElementType.TYPE)//表示注解可以用来类、接口、枚举
@Retention(RetentionPolicy.RUNTIME)//注解信息在运行时也会保留，可以被反射到
public @interface RemoteService {
}
