package com.advanced.dome.mybatis.annotation;

import java.lang.annotation.*;

/**
 * @author guohong
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface select {

    String value();

}
