package com.cyl.rpc;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author Administrator
 * @Date 2020/9/9 9:55
 * @Version 1.0
 */
@Target(ElementType.TYPE) //作用范围类或者接口
@Retention(RetentionPolicy.RUNTIME)
@Component //spring进行扫描
public @interface RpcService {
    Class<?> value();
}
