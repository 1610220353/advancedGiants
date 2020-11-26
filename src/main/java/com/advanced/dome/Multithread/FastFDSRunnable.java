package com.advanced.dome.multithread;

import org.apache.poi.util.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;

/**
 * 类描述:
 *
 * @author: guohong
 * @date: 2020-09-16 16:42
 */
public class FastFDSRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
    }

    public void processCommand() {

        try {
            Thread.sleep(10);
            FastDFSUtil fastDFSUtil = null;
            try {
                fastDFSUtil = new FastDFSUtil();

                File file = new File("D:\\Desktop\\上传.txt");
                InputStream fis = new FileInputStream(file);
                byte[] bytes = IOUtils.toByteArray(fis);
//                System.out.println(fastDFSUtil.uploadFile(bytes,"1.txt"));

            } catch (Exception e) {
                e.printStackTrace();
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
