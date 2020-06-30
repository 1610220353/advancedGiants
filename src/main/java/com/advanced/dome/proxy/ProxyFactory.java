package com.advanced.dome.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author guohong
 */
public class ProxyFactory {

    public static Object getDynProxy(Object target) {
        InvocationHandler handler = new DynProxyLawyer(target);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
    }

    public static void main(String[] args) {
        ILawSuit proxy= (ILawSuit) ProxyFactory.getDynProxy(new Zhangsan());
        proxy.submit("工资流水在此");
        proxy.defend();
    }

}
