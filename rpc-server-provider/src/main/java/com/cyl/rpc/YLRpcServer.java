package com.cyl.rpc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Administrator
 * @Date 2020/9/9 10:04
 * @Version 1.0
 */
@Component
public class YLRpcServer implements ApplicationContextAware, InitializingBean {
    ExecutorService executorService = Executors.newCachedThreadPool();
    private Map<String,Object> serviceNameMap = new ConcurrentHashMap();
    private int port;

    public YLRpcServer(int port) {
        this.port = port;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while (true){
                Socket socket = serverSocket.accept();
                //通过线程池去做每个请求，伪非阻塞
                executorService.execute(new ProcessorHandler(socket,serviceNameMap));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(serverSocket!=null){
                serverSocket.close();
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(RpcService.class);
        if(!beansWithAnnotation.isEmpty()){
            for (Object serviceBean:beansWithAnnotation.values()) {
                RpcService annotation = serviceBean.getClass().getAnnotation(RpcService.class);
                String serviceName = annotation.value().getName();
                serviceNameMap.put(serviceName,serviceBean);
            }
        }
    }
}
