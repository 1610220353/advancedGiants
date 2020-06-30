package com.advanced.dome.aliExcel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Font;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.metadata.TableStyle;
import org.apache.poi.ss.usermodel.IndexedColors;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author guohong
 */
public class WriteExcel {


    public void WriteExcel_1() throws IOException {
        //文件输出位置
        OutputStream outputStream = new FileOutputStream("D:\\Desktop\\test.xlsx");

        ExcelWriter writer = EasyExcelFactory.getWriter(outputStream);

        Sheet sheet = new Sheet(0, 1, WriteModel.class);
        //传递第一个sheet名称
        sheet.setSheetName("哈哈哈");

        writer.write(getWriteModels(), sheet);
        writer.finish();
        outputStream.close();


    }

    /**
     * 动态生成Excel
     *
     * @throws IOException
     */
    public void DynamicWriteExcel() throws IOException {
        //文件输出位置
        OutputStream outputStream = new FileOutputStream("D:\\Desktop\\test.xlsx");

        ExcelWriter writer = EasyExcelFactory.getWriter(outputStream);

        Sheet sheet = new Sheet(0, 1);
        //传递第一个sheet名称
        sheet.setSheetName("哈哈哈");
        //创建一个表格，用于sheet的使用
        Table table = new Table(1);
        //无注解模式，动态添加表头
        table.setHead(creatHeadList());
        writer.write1(creatDynamicWriteModels(), sheet, table);

        writer.finish();
        outputStream.close();

    }
    /**
     * 动态生成Excel 并定义格式
     *
     * @throws IOException
     */
    public void DynamicWriteExcel_1() throws IOException {
        //文件输出位置
        OutputStream outputStream = new FileOutputStream("D:\\Desktop\\test.xlsx");

        ExcelWriter writer = EasyExcelFactory.getWriter(outputStream);

        Sheet sheet = new Sheet(0, 1);
        //传递第一个sheet名称
        sheet.setSheetName("哈哈哈");
        //创建一个表格，用于sheet的使用
        Table table = new Table(1);
        //自定义表头格式
        table.setTableStyle(creatTableStyle());
        //无注解模式，动态添加表头
        table.setHead(creatHeadList());

        writer.write1(creatDynamicWriteModels(), sheet, table);
        //合并单元格 注意下标是从 0 开始的，也就是说合并了第4行到第6行，其中的第1列到第2列，注意这个合并单元格是必须在write1下面的
        writer.merge(3,5,0,1);
        writer.finish();
        outputStream.close();

    }

    /**
     * 有注解的生成方式
     *
     * @return
     */
    private List<WriteModel> getWriteModels() {
        List<WriteModel> writeModels = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            WriteModel writeModel = new WriteModel();
            writeModel.setUserName("a" + i);
            writeModel.setPassword("abcd" + i);
            writeModels.add(writeModel);
        }
        return writeModels;

    }
    /**
     * 自定义表头样式
     */
    private TableStyle creatTableStyle(){

        TableStyle tableStyle = new TableStyle();
        //设置表头样式
        Font font = new Font();
        //字体是否加粗
        font.setBold(true);
        font.setFontName("黑体");
        //字体大小
        font.setFontHeightInPoints((short) 12);
        tableStyle.setTableContentFont(font);
        //设置背景颜色
        tableStyle.setTableContentBackGroundColor(IndexedColors.AQUA);

        //设置表格主体样式
        Font font1 = new Font();
        font1.setFontName("楷体");
        font1.setFontHeightInPoints((short) 12);
        tableStyle.setTableContentFont(font1);
        tableStyle.setTableContentBackGroundColor(IndexedColors.BLUE);

        return tableStyle;
    }


    /**
     * 无注解的方式
     *
     * @return
     */
    private List<List<Object>> creatDynamicWriteModels() {
        List<List<Object>> model = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            List<Object> list = new ArrayList<>();

            list.add("名称" + i);
            list.add("密码" + i);
            model.add(list);
        }
        return model;

    }


    /**
     * 生成表头所需要的List<List<String>> 类型的 数据
     *
     * @return
     */
    public static List<List<String>> creatHeadList() {
        List<List<String>> head = new ArrayList<>();

        List<String> column_1 = new ArrayList<>();
        List<String> column_2 = new ArrayList<>();
        column_1.add("名称");
        column_1.add("名称");
        column_2.add("密码");

        head.add(column_1);
        head.add(column_2);
        return head;

    }

    public static void main(String[] args) throws IOException {
        WriteExcel writeExcel = new WriteExcel();
        writeExcel.DynamicWriteExcel_1();
    }
}
