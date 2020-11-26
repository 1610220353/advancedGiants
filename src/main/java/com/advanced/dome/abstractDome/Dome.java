package com.advanced.dome.abstractDome;

import java.util.HashMap;
import java.util.Map;

/**
 * 类描述:
 *
 * @author: guohong
 * @date: 2020-11-23 14:04
 */
public abstract class Dome {

    public void test() {
        Map<String,String> map = new HashMap<>();
        map.put("2","3");
        System.out.println(testDome(map));
        System.out.println(map);
    }


    public abstract String testDome(Map<String,String> map);

}
