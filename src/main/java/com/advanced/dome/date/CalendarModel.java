package com.advanced.dome.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author guohong
 * Calendar 测试
 */
public class CalendarModel {

    public static void main(String[] args) {
        // 其日历字段已由当前日期和时间初始化：
        Calendar rightNow = Calendar.getInstance();
        //获取年
        System.out.println(rightNow.get(Calendar.YEAR));
        //获取月 需要加一
        System.out.println(rightNow.get(Calendar.MARCH) + 1);

        System.out.println(rightNow.get(Calendar.DATE));

        Date start = new Date("yyyy-MM-dd");

        rightNow.setTime(start);

    }

}
