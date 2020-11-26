package com.advanced.dome.redis;

import java.util.HashMap;
import java.util.Map;

/**
 * redis 测试类
 */
public class RedisDome {

    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();
        map.put("k1","234");
        map.put("haha","sdg");
        System.out.println(map);
        Map<String,String> map1 = new HashMap<>();
        map1.putAll(map);
        map1.put("k1","1243");

        System.out.println(map1);



    }
}
