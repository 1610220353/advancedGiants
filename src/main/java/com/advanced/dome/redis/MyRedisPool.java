package com.advanced.dome.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * @author guohong
 */
public class MyRedisPool {

    private final static Logger logger = LoggerFactory.getLogger(MyRedisPool.class);

    private static JedisPool readPool = null;
    private static JedisPool writePool = null;


    //静态代码初始化池配置
    static {
        try{
            Properties props = new Properties();
            InputStream in = MyRedisPool.class.getResourceAsStream("/redis.properties");
            props.load(in);

            //创建jedis池配置实例
            JedisPoolConfig config = new JedisPoolConfig();
            //设置池配置项值
            //maxTotal：默认值8  资源池中最大连接数
            config.setMaxTotal(Integer.parseInt(props.getProperty("jedis.pool.maxActive")));
            //maxIdle:默认值8 资源池允许最大空闲的连接数
            config.setMaxIdle(Integer.parseInt(props.getProperty("jedis.pool.maxIdle")));
            //maxWaitMillis：默认值-1 表示永不超时 当资源池连接用尽后，调用者的最大等待时间(单位为毫秒)
            config.setMaxWaitMillis(Long.parseLong(props.getProperty("jedis.pool.maxWait")));
            //testOnBorrow：在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；默认是false
            //向资源池借用连接时是否做连接有效性检测(ping)，无效连接会被移除
            //业务量很大时候建议设置为false(多一次ping的开销)。
            config.setTestOnBorrow(Boolean.parseBoolean(props.getProperty("jedis.pool.testOnBorrow")));
            //向资源池归还连接时是否做连接有效性检测(ping)，无效连接会被移除  业务量很大时候建议设置为false(多一次ping的开销)
            config.setTestOnReturn(Boolean.parseBoolean(props.getProperty("jedis.pool.testOnReturn")));

            //根据配置实例化jedis池
            //读写分离 采取主从同步
            readPool = new JedisPool(config, props.getProperty("redisReadURL"), Integer.parseInt(props.getProperty("redisReadPort")));
            writePool = new JedisPool(config, props.getProperty("redisWriteURL"), Integer.parseInt(props.getProperty("redisWritePort")));

        }catch (IOException e) {
            logger.info("redis连接池异常",e);
        }
    }



    /**获得jedis对象*/
    public static Jedis getReadJadesObject(){
        return readPool.getResource();
    }
    /**获得jedis对象*/
    public static Jedis getWriteJadesObject(){
        return writePool.getResource();
    }

    /**归还jedis对象*/
    public static void returnJediObjects(Jedis jedis){
        if (jedis != null) {
            jedis.close();
        }
    }
}
