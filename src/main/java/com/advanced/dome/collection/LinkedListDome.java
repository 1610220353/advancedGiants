package com.advanced.dome.collection;

import java.util.*;

import static com.sun.xml.internal.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY;

/**
 * @author guohong
 */
public class LinkedListDome {

    int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
    static final int hash(Object key) {
        int h;
        //这个地方又有个问题，(h = key.hashCode()) ^ (h >>> 16) 是 高16位和低16位做异或运算，目的是散列更均匀
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);

    }
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();

        map.put("1","1");
        map.put("1","2");
        for (String key : map.keySet()) {
            System.out.print(key + " -> ");
            System.out.println(map.get(key));
        }
        System.out.println(3<<1);

    }
}
