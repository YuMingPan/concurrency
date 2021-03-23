package com.ifeve.chapter04;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * 4-17
 *
 * <p>3.将获取连接的方法包装起来
 */
public class ConnectionDriver {

    // 静态内部类
    static class ConnectionHandler implements InvocationHandler {

        // 2.对被代理的接口的操作，转移到"代理对象"上
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("commit")) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            return null;
        }
    }

    // 1.创建一个Connection的代理，可以理解为Connection的实现类对象
    public static final Connection createConnection() {
        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(), new Class<?>[] { Connection.class },
            new ConnectionHandler());
    }
}
