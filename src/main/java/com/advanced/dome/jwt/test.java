package com.advanced.dome.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

    public void testCreat(){

        Date loginTime = new Date();	//登录时间
        Date limitTime = new Date(loginTime.getTime() + 6000000);	//设置过期时间为1分钟

        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("111")  //用户id
                .setSubject("小周")    //用户名
                .setIssuedAt(loginTime)//登录时间
                .signWith(SignatureAlgorithm.HS256,"zhouran1")  //指定头和盐
                .setExpiration(limitTime)
                                .claim("roles","admin")//添加自定义属性
                .claim("hobby","code") ;//添加自定义属性

        System.out.println(jwtBuilder.compact());//将jwtBuilder变成字符串

        //结果：
        //eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMTEiLCJzdWIiOiLlsI_lkagiLCJpYXQiOjE1ODQyNTczMzcsImV4cCI6MTU4NDI1NzM5N30.bctrsV-FId6vspTsGu144gJR_swrE_ZiVD8wrGUI9k4

    }
    public void testParse(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMTEiLCJzdWIiOiLlsI_lkagiLCJpYXQiOjE1OTI5NTkxODAsImV4cCI6MTU5Mjk2NTE4MCwicm9sZXMiOiJhZG1pbiIsImhvYmJ5IjoiY29kZSJ9.LWYr_OKSsuhu0mxHcts2s8IzAh4GJZALjnYJKvwcrpY";
        Claims claims = Jwts.parser()
                .setSigningKey("zhouran")  //盐
                .parseClaimsJws(token)	//需要解析的token
                .getBody();	  //返回一个Claims对象，里面是键值对

        System.out.println("用户id:"+claims.getId());
        System.out.println("用户昵称:"+claims.getSubject());
        System.out.println("角色:"+claims.get("roles"));
        System.out.println("爱好:"+claims.get("hobby"));
    }

    public static void main(String[] args) {
        test test = new test();
//        test.testCreat();
        test.testParse();
    }
}
