package com.advanced.dome.mybatis.aop;

import com.advanced.dome.mybatis.annotation.select;
import com.sun.org.apache.bcel.internal.generic.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author guohong
 * 使用jdk的形式使用aop
 */
public class MybatisInvocationHandler implements InvocationHandler {


    /**
     * 需要被代理的对象
     */
    private Object object;

    public MybatisInvocationHandler(Object object) {
        this.object = object;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("使用JDK动态代理拦截Mapper接口");
        System.out.println("需要被代理的接口：" + object);
        System.out.println("需要执行的方法：" + method.getName());
        //获取注解
        select select = method.getDeclaredAnnotation(select.class);
        if(select!=null) {
            return excuteSelect(select,proxy,method,args);
        }

        return null;
    }
    private Object excuteSelect(select select, Object proxy, Method method, Object[] args) {
        String selectSql = select.value();
        System.out.println("需要执行的SQL语句："+selectSql);
        return null;
    }
}
