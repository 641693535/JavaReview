package com.java3;

import org.junit.Test;

import java.io.*;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-16 21:37
 */
public class Encoding {
    /**
     * 使用转换流InputStream
     * 将dbcp.txt转换成gbk编码格式
     */
    @Test
    public void test1(){
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            FileInputStream fis = new FileInputStream("dbcp.txt");
            FileOutputStream fos = new FileOutputStream("dbcp-gbk.txt");
            //创建转换流中字符输入流
            isr = new InputStreamReader(fis,"UTF-8");
            osw = new OutputStreamWriter(fos, "GBK");

            char[] cbuf = new char[128];
            int len;
            while ((len = isr.read(cbuf)) != -1) {
                osw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

}
