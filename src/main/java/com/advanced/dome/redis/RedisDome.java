package com.advanced.dome.redis;

import redis.clients.jedis.Jedis;

/**
 * redis 测试类
 */
public class RedisDome {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);

        //使用redis命令
        jedis.ping();
        jedis.set("k1", "v1");
        System.out.println(jedis.get("k1"));


    }
}
