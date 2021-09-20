package com.rpc.example.service;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Package: com.rpc.example.service
 * @ClassName: RpcServerProperties
 * @Author: zyh
 * @CreateTime: 2021/9/20 3:09 下午
 * @Description:
 */
@Data
@ConfigurationProperties(prefix = "rpc")
public class RpcServerProperties {

    private int servicePort;
}
