package com.cyl.rpc;

/**
 * @Author Administrator
 * @Date 2020/9/8 21:21
 * @Version 1.0
 */
public interface IHelloService {
    String sayHello(String content);
    String saveUser(User user);
}
