package com.cyl.rpc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Administrator
 * @Date 2020/9/8 21:29
 * @Version 1.0
 */
public class RpcProxyServer {
   /* ExecutorService executorService = Executors.newCachedThreadPool();
    public void publisher(int port,Object service) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while (true){
                Socket socket = serverSocket.accept();
                //通过线程池去做每个请求，伪非阻塞
                executorService.execute(new ProcessorHandler(socket,service));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(serverSocket!=null){
               serverSocket.close();
            }
        }
    }*/
}
