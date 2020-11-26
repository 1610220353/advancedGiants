package com.advanced.dome.mybatis;

import com.advanced.dome.mybatis.mapper.UserMapper;
import com.advanced.dome.mybatis.sqlSession.SqlSession;

import java.sql.ResultSet;
import java.util.*;

/**
 * @author guohong
 * 测试
 */
public class Test {

    public static void main(String[] args) {
        UserMapper userMapper = SqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.selectUserByUserName("123"));

        List<String> list = new ArrayList();

        list.add("123");
        list.add("1213");
        list.add("12cds3");
        list.add("sc");


//        ResultSet rs = null;
//
//        while (rs.next()) {
//            list.add(rs.getString(0));
//
//        }
        StringBuffer sb = new StringBuffer("select");

        String a = "1234";
        a.substring(0,a.length() - 2);
        System.out.println(a);
    }
}
