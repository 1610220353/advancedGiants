package com.advanced.dome.redis;

import java.util.HashMap;
import java.util.Map;

/**
 * redis 测试类
 */
public class RedisDome {

    public static void main(String[] args) {


//        System.out.println(RedisUtils.setKv("k1",100,"a"));

        Map<String,String> map = new HashMap<>();
        map.put("k1","234");
        map.put("haha","sdg");
        System.out.println(RedisUtils.getHashAllKey("test"));


    }
}
