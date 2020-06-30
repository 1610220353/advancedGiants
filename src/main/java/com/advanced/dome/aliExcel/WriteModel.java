package com.advanced.dome.aliExcel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @author guohong
 * 首先，定义的写入模型必须要继承自 BaseRowModel.java;
 */

public class WriteModel extends BaseRowModel {


    /**
     * 通过 @ExcelProperty 注解来指定每个字段的列名称，以及下标位置；
     */
    @ExcelProperty(value = "名称",index = 0)
    private String userName;

    @ExcelProperty(value = "密码",index = 1)
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
