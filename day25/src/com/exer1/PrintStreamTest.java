package com.exer1;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO 打印流测试
 * @Date 2021-06-16 22:50
 */
public class PrintStreamTest {

    @Test
    public void test1(){
        PrintStream ps = null;
        try {
            //创建存储的字节文件
            FileOutputStream fos = new FileOutputStream("print.txt");

            //创建打印流对象
            ps = new PrintStream(fos);
            if (ps != null) {
                System.setOut(ps);
            }
            for (int i = 0; i < 255; i++) {
                char c = (char) i;
                System.out.print(c);
                if (i % 50 == 0) {
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }


    }

}
