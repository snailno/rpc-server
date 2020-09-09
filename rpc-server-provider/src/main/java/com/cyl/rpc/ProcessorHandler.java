package com.cyl.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @Author Administrator
 * @Date 2020/9/8 21:33
 * @Version 1.0
 */
public class ProcessorHandler implements Runnable{
    private Socket socket;
    public ProcessorHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            //客服端通过socket发来请求数据
            //请求的哪个类，方法，参数
            RpcRequest rpcRequest = (RpcRequest) objectInputStream.readObject();
            Object result = invoke(rpcRequest);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(result);
            objectOutputStream.flush();
        } catch (IOException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            if(objectInputStream!=null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(objectOutputStream!=null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Object invoke(RpcRequest rpcRequest) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Object[] args = rpcRequest.getParameters();
        Class<?>[] types = new Class[args.length];
        for (int i=0;i<args.length;i++){
            types[i] = args[i].getClass();
        }
        Class<?> clazz = Class.forName(rpcRequest.getClassName());
        Class<HelloServiceImpl> helloServiceClass = HelloServiceImpl.class;

        Object service = helloServiceClass.newInstance();
        Method method = clazz.getMethod(rpcRequest.getMethodName(), types);
        Object result = method.invoke(service,args);
        return result;
    }
}
