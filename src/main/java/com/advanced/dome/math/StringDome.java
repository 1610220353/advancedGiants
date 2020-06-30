package com.advanced.dome.math;

import java.util.Arrays;
import java.util.Random;

/**
 * @author guohong
 * 测试 String 类型常用方法
 */
public class StringDome {


    public  void main1(String[] args) {
        String dome1 = "1d.om.e.1";
        String dome2 = "dome2";

        //字符串查找 没有返回-1
        System.out.println(dome1.indexOf("2"));
        //查找最后字符出现的索引位置 如果指定的字符串为空 返回的是和 .length() 方法结果一致 结果显示为 5
        System.out.println(dome1.lastIndexOf("1"));

        //截取字符串 结果显示为do
        System.out.println(dome1.substring(1, 3));

        //去除空格 将字符串两边的空白(\t、Tab等)去除掉.
        System.out.println(dome1.trim());

        //替换字符串 2dome2
        System.out.println(dome1.replaceAll("1", "2"));
        //判断该字符串是否在头使用 startWith  结束用endsWith() 返回 boolean
        System.out.println(dome1.startsWith("2"));

        //比较相等equals() 忽略大小写啦比较相等equalsIgnoreCase
        //通过指定字符串进行分割

        String str = "root:x:0:0:root:/root:/bin/bash";
        String[] split = str.split(":");

        System.out.println(Arrays.toString(split));

        //使用正则表达式判断 是否为数字
        System.out.println(dome1.matches("[0-9]+"));
        System.setProperty("dome",dome1);


        System.out.println(System.getProperty("dome"));

        //随机生成数 从0-1000000
        Random random = new Random();
        System.out.println(random.nextInt(1000000));
        System.out.println(Math.random() * 100000);
        StringBuffer stringBuffer = new StringBuffer("ahsj");
        stringBuffer.append("a");

    }

    public static void main(String[] args) {
        String a = "a";
        String b = new String("a");
        String c = "a";
        System.out.println(a.equals(c));
        System.out.println(a==c);

    }
}
