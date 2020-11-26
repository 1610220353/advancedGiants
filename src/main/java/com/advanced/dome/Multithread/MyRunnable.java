package com.advanced.dome.multithread;

import java.util.Date;

/**
 * @author guohong
 * @date 2020年5月27日17:32:43
 * 创建 Runnable  用于测试 ThreadPoolExecutor
 */
public class MyRunnable implements Runnable{

    private String command;

    public MyRunnable(String s) {
        this.command = s;
    }

    @Override
    public void run() {
//        System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
        processCommand();
//        System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
    }

    /**
     * 模拟数据请求
     */
    public void processCommand() {


        try {
            System.out.println("测试" + command);
            Thread.sleep(100);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
