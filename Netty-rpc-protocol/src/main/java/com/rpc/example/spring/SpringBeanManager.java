package com.rpc.example.spring;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Package: com.rpc.example.spring
 * @ClassName: SpringBeanManager
 * @Author: zyh
 * @CreateTime: 2021/9/18 4:52 下午
 * @Description:
 */
@Deprecated
@Component
@Data
public class SpringBeanManager implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringBeanManager.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> clzz){
        return applicationContext.getBean(clzz);
    }

}
