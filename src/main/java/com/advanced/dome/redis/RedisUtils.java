package com.advanced.dome.redis;

import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Set;

/**
 * @author guohong
 */
public class RedisUtils {


    /**
     * 获取hash表中所有key
     *
     * @param name
     * @return
     */
    public static Set<String> getHashAllKey(String name) {
        Jedis jedis = null;
        try {
            jedis = MyRedisPool.getReadJadesObject();
            return jedis.hkeys(name);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyRedisPool.returnJediObjects(jedis);
        }
        return null;
    }

    /**
     * 从redis hash表中获取
     *
     * @param hashName
     * @param key
     * @return
     */
    public static String getHashKv(String hashName, String key) {
        Jedis jedis = null;
        try {
            jedis = MyRedisPool.getReadJadesObject();
            return jedis.hget(hashName, key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyRedisPool.returnJediObjects(jedis);
        }
        return null;
    }

    /**
     * 删除hash表的键值对
     *
     * @param hashName
     * @param key
     */
    public static Long delHashKv(String hashName, String key) {
        Jedis jedis = null;
        try {
            jedis = MyRedisPool.getWriteJadesObject();
            return jedis.hdel(hashName, key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyRedisPool.returnJediObjects(jedis);
        }
        return null;
    }

    /**
     * 存放hash表键值对
     *
     * @param hashName
     * @param key
     * @param value
     */
    public static Long setHashKv(String hashName, String key, String value) {
        Jedis jedis = null;
        try {
            jedis = MyRedisPool.getWriteJadesObject();

            return jedis.hset(hashName, key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyRedisPool.returnJediObjects(jedis);
        }
        return null;
    }

    /**
     * 键值对以map的方式储存
     * @param hashName
     * @param map
     * @return
     */
    public static String setHashKvMap(String hashName, Map<String,String> map) {
        Jedis jedis = null;
        try {
            jedis = MyRedisPool.getWriteJadesObject();
            return jedis.hmset(hashName, map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyRedisPool.returnJediObjects(jedis);
        }
        return null;
    }

    /**
     * 删除键值对
     *
     * @param k
     * @return
     */
    public static Long delKv(String k) {
        Jedis jedis = null;
        try {
            jedis = MyRedisPool.getWriteJadesObject();
            return jedis.del(k);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyRedisPool.returnJediObjects(jedis);
        }
        return null;
    }

    /**
     * 放键值对
     * 永久
     *
     * @param k
     * @param v
     */
    public static String setKv(String k, String v) {
        Jedis jedis = null;
        try {
            jedis = MyRedisPool.getWriteJadesObject();
            return jedis.set(k, v);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyRedisPool.returnJediObjects(jedis);
        }
        return null;
    }


    /**
     * 放键值对
     *
     * @param k
     * @param v
     * @param second 过期时间
     */
    public static String setKv(String k, int second, String v) {
        Jedis jedis = null;
        try {
            jedis = MyRedisPool.getWriteJadesObject();
            return jedis.setex(k, second, v);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyRedisPool.returnJediObjects(jedis);
        }
        return null;
    }

    /**
     * 根据key取value
     *
     * @param k
     * @return
     */
    public static String getKv(String k) {
        Jedis jedis = null;
        try {
            jedis = MyRedisPool.getReadJadesObject();
            return jedis.get(k);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyRedisPool.returnJediObjects(jedis);
        }
        return null;
    }


}
