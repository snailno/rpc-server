package com.cyl.rpc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*IHelloService helloService = new HelloServiceImpl();
        RpcProxyServer proxyServer = new RpcProxyServer();
        proxyServer.publisher(8080,helloService);*/
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        annotationConfigApplicationContext.start();
    }
}
