package com.cyl.rpc;

import java.io.Serializable;

/**
 * @Author Administrator
 * @Date 2020/9/8 21:39
 * @Version 1.0
 */
public class RpcRequest implements Serializable {
    private String className;
    private String methodName;
    private Object[] parameters;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
