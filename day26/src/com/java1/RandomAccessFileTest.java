package com.java1;

import org.junit.Test;

import java.io.*;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO 通过随机存储文件流进行复制图片
 * @Date 2021-06-17 22:50
 */
public class RandomAccessFileTest {

    @Test
    public void test1() {
        RandomAccessFile readRaf = null;
        RandomAccessFile writeRaf = null;
        try {
            //创建随机存储文件流实例
            readRaf = new RandomAccessFile("爱情与友情.jpg", "r");
            writeRaf = new RandomAccessFile("爱情与友情_copy.jpg", "rw");

            //读取文件，复制文件的操作
            byte[] b = new byte[1024];
            int len;
            while ((len = readRaf.read(b)) != -1) {
                writeRaf.write(b,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writeRaf != null) {
                //关闭流
                try {
                    writeRaf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (readRaf != null) {
                try {
                    readRaf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * 使用随机存储文件流对文本文件进行修改
     */
    @Test
    public void test2() {

        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("hello.txt", "rw");

            raf.write("123321".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    /**
     * 使用RandomAccessFile实现插入数据效果
     */
    @Test
    public void test3() {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("hello.txt", "rw");

            //通过seek方法将指针调到3的位置
            raf.seek(3);

            //将3指针后面的所有数据保存到StringBuilder中
            StringBuilder sb = new StringBuilder((int) new File("hello.txt").length());
            byte[] b = new byte[5];
            int len;
            while ((len = raf.read(b)) != -1) {
                sb.append(new String(b, 0, len));
            }

            //将指针调回3的位置，并写入数据
            raf.seek(3);
            raf.write("HelloWorld!".getBytes());
            raf.write(sb.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
