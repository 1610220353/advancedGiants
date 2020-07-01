package com.advanced.dome.multithread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author guohong
 */
public class ThreadPoolExecutorDemo {

    /**
     * 核心线程数
     */
    private static final int CORE_POOL_SIZE = 5;
    /**
     * 最大线程数
     */
    private static final int MAX_POOL_SIZE = 10;
    /**
     * 任务队列为 ArrayBlockingQueue，并且容量为 100
     */
    private static final int QUEUE_CAPACITY = 100;
    /**
     * 等待时间为
     */
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        //使用阿里巴巴推荐的创建线程池的方式
        // 通过ThreadPoolExecutor构造函数 自定义参数创建
        //corePoolSize: 核心线程数为 5。
        //maximumPoolSize ：最大线程数 10
        //keepAliveTime : 等待时间为 1L。
        //unit: 等待时间的单位为 TimeUnit.SECONDS。
        //workQueue：任务队列为 ArrayBlockingQueue，并且容量为 100;
        //handler:饱和策略为 CallerRunsPolicy。
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        for (int i = 0; i < MAX_POOL_SIZE; i++) {
            Runnable worker = new MyRunnable("" + i);

            executor.execute(worker);

        }
        //终止线程池
        executor.shutdown();


    }
}
