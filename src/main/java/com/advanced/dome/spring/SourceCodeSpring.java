package com.advanced.dome.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author guohong
 * spring 源码分析
 */
public class SourceCodeSpring {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");

    }
}
