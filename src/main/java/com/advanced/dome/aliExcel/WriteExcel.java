package com.advanced.dome.aliExcel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author guohong
 */
public class WriteExcel {



    public WriteExcel() throws IOException {
        //文件输出位置
        OutputStream outputStream = new FileOutputStream("D:\\Desktop\\test.xlsx");

        ExcelWriter writer = EasyExcelFactory.getWriter(outputStream);

        Sheet sheet = new Sheet(0,1,WriteModel.class);
        //传递第一个sheet名称
        sheet.setSheetName("哈哈哈");

        writer.write(getWriteModels(),sheet);
        writer.finish();
        outputStream.close();



    }
    private List<WriteModel> getWriteModels() {
        List<WriteModel> writeModels = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            WriteModel writeModel = new WriteModel();
            writeModel.setUserName("a"+i);
            writeModel.setPassword("abcd"+i);
            writeModels.add(writeModel);
        }
        return writeModels;

    }

    public static void main(String[] args) throws IOException {
        WriteExcel writeExcel = new WriteExcel();
    }
}
