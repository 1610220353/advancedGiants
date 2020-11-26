package com.advanced.dome.md5;

import org.apache.commons.codec.binary.Base64;
import org.apache.poi.util.IOUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * @author guohong
 */
public class Base64Utils extends Base64 {

    /**
     * BASE64解密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * BASE64加密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }


    public static void main(String[] args) throws Exception {

        File file = new File("D:\\Documents\\常用文件\\sql.txt");
        InputStream fis = new FileInputStream(file);
        byte[] bytes = IOUtils.toByteArray(fis);
        System.out.println(Base64Utils.encryptBASE64(bytes));

    }
}
