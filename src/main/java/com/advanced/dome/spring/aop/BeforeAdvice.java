package com.advanced.dome.spring.aop;

import java.lang.reflect.Method;

/**
 * @author guohong
 * 前置通知
 */
public class BeforeAdvice implements Advice {

    private Object bean;
    private MethodInvocation methodInvocation;

    public BeforeAdvice(Object bean,MethodInvocation methodInvocation) {

        this.bean = bean;
        this.methodInvocation = methodInvocation;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        //在目标方法之前执行通知
        methodInvocation.invoke();
        return method.invoke(bean,args);
    }
}
