package com.java1;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-15 22:16
 */
public class FileReaderTest {

    @Test
    public void test1() {

        FileReader fileReader = null;
        try {
            File file = new File("hello.txt");

            fileReader = new FileReader(file);
            int read;
            while ((read = fileReader.read()) != -1) {
                System.out.print((char) read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test2() {
        FileReader fr = null;
        try {
            //创建File的实例化
            File f = new File("hello.txt");
            //创建读入的字符流
            fr = new FileReader(f);
            //读取输出字符
            char[] cbuf = new char[5];

            int read;
            while ((read = fr.read(cbuf)) != -1) {
//                for (int i = 0; i < read; i++) {
//                    System.out.print(cbuf[i]);
//                }
                System.out.print(new String(cbuf,0,read));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                //关闭流
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
