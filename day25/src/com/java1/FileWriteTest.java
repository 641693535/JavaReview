package com.java1;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-15 22:59
 */
public class FileWriteTest {

    @Test
    public void test1(){
        FileWriter fw = null;

        try {
            //创建File类的对象
            File file = new File("hello.txt");

            //创建写出字符流
            fw = new FileWriter(file,true);

            //写出
            fw.write("HelloWorld\n");
            fw.write("I have a Dream!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    //关闭流
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }
    @Test
    public void test2(){
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File writeFile = new File("hellotxt.txt");
            File readFile = new File("hello.txt");

            //创建输入输出字符流
            fr = new FileReader(readFile);
            fw = new FileWriter(writeFile);

            //将输入的数据输出
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
//                fw.write(new String(cbuf, 0, len));
                fw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                //关闭流
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
