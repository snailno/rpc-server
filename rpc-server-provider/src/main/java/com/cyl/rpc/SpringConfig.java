package com.cyl.rpc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Administrator
 * @Date 2020/9/9 10:05
 * @Version 1.0
 */
@Configuration
@ComponentScan(basePackages = "com.cyl.rpc")
public class SpringConfig {
    @Bean(name = "YLRpcServer")
    public YLRpcServer ylRpcServer(){
        return new YLRpcServer(8080);
    }
}
