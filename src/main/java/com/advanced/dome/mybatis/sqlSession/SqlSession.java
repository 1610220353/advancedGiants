package com.advanced.dome.mybatis.sqlSession;

import com.advanced.dome.mybatis.aop.MybatisInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * @author guohong
 */
public class SqlSession {

    public static <T> T getMapper(Class<?> classz) {
        return (T) Proxy.newProxyInstance(classz.getClassLoader(), new Class[]{classz}, new MybatisInvocationHandler(classz));
    }
}
