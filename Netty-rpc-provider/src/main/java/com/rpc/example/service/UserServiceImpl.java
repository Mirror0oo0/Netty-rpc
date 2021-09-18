package com.rpc.example.service;

import com.rpc.example.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Package: com.rpc.example.service
 * @ClassName: UserServiceImpl
 * @Author: zyh
 * @CreateTime: 2021/9/17 9:54 下午
 * @Description:
 */
@Service
@Slf4j
public class UserServiceImpl implements IUserService {
    @Override
    public String saveUser(String name) {
        log.info("begin save user:{}",name);
        return "save User success :{}"+name  ;
    }
}
