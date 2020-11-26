package com.advanced.dome.collection;

import org.apache.commons.codec.binary.Base64;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author guohong
 */
public class ListDome {


    private boolean isSkip(String path) {
        Stream<String> stringStream = AuthProvider.getDefaultSkipUrl().stream().map(url -> url.replace(AuthProvider.TARGET, AuthProvider.REPLACEMENT));
        stringStream.forEach(a -> {
            System.out.println(a);
            System.out.println(path.startsWith(a));
        });
        return AuthProvider.getDefaultSkipUrl().stream().map(url -> url.replace(AuthProvider.TARGET, AuthProvider.REPLACEMENT)).anyMatch(path::startsWith);
    }

    public void test() {

        System.out.println("调用成功");
    }

    public void test1() {
        test();
    }

    public static void main(String[] args) {



        List<Map<String,String>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map<String,String> map = new HashMap<>();
            map.put(i +"ha",i+ "");
            list.add(map);
        }

        Map<String, String> collect = list.stream().flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a));
//        System.out.println(collect);

//        for (int i = 1; i < 4; i+=2) {
//
//            System.out.println(i);
//        }
//            SimpleDateFormat df = new SimpleDateFormat("yyyyMM");//设置日期格式
//        df.format(new Date());
//            System.out.println(df.format(new Date()));// new Date()为获取当前系统时间


        String id = "1e2416c0-19c7-11eb-8803-0954643c5bb5";
        String s = UUID.randomUUID().toString();
        System.out.println(s.length());

    }


}
