package com.advanced.dome.spring.aop;

import java.lang.reflect.Proxy;

/**
 * @author guohong
 * 定义一个包含切面逻辑的对象，这里假设叫 logMethodInvocation
 * 定义一个 Advice 对象（实现了 InvocationHandler 接口），并将上面的 logMethodInvocation 和 目标对象传入
 * 将上面的 Adivce 对象和目标对象传给 JDK 动态代理方法，为目标对象生成代理
 */
public class SimpleAop {

    public static Object getProxy(Object bean, Advice advice) {
        return Proxy.newProxyInstance(SimpleAop.class.getClassLoader(),
                bean.getClass().getInterfaces(), advice);
    }

    public static void main(String[] args) {
        MethodInvocation loTask = new MethodInvocation() {
            @Override
            public void invoke() {
                System.out.println("lll");
            }
        };
        HelloService helloService = new HelloServiceImpl();

        // 2. 创建一个 Advice
        Advice beforeAdvice = new BeforeAdvice(helloService, loTask);

        // 3. 为目标对象生成代理
        HelloService helloServiceImplProxy = (HelloService) SimpleAop.getProxy(helloService,beforeAdvice);

        helloServiceImplProxy.sayHelloWorld();
    }
}
