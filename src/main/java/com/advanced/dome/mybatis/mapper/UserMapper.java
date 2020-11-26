package com.advanced.dome.mybatis.mapper;

import com.advanced.dome.mybatis.annotation.select;

import java.util.List;

/**
 * @author guohong
 */
public interface UserMapper {

    /**
     *
     * @param userName
     * @return
     */
    @select(value = "select * from abd where hah = #{ip}")
     List<String> selectUserByUserName(String userName);
}
