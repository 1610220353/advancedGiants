package com.advanced.dome.abstractDome;

import java.util.Map;

/**
 * 类描述:
 *
 * @author: guohong
 * @date: 2020-11-23 14:10
 */
public class DomeImpl extends Dome {
    @Override
    public String testDome(Map<String,String> map) {
        map.put("1","2");
        return "DomeImpl";
    }
}
