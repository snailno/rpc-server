package com.cyl.rpc;

/**
 * @Author Administrator
 * @Date 2020/9/8 21:25
 * @Version 1.0
 */
public class HelloServiceImpl implements IHelloService{
    @Override
    public String sayHello(String content) {
        System.out.println("request in sayHello:" +content);
        return "say hello:"+content;
    }

    @Override
    public String saveUser(User user) {
        System.out.println("request in saveUser:" +user);
        return "SUCCESS";
    }
}
