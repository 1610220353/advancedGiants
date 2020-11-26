package com.advanced.dome.redis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedisCluster {
    public static void main(String[] args) {


        Map<String,String> map = null;

        int i = 3000113;
        long timeMillis = System.currentTimeMillis();
        for (int i1 = 0; i1 < i; i1++) {
            map = new HashMap<>();
            map.put("test"+i,"123");

        }
        long t = System.currentTimeMillis();
        System.out.println(t-timeMillis);


    }
}
