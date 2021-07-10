package com.exer1;

import org.junit.Test;

import java.io.*;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO 数据流
 * @Date 2021-06-16 23:15
 */
public class DataStreamTest {

    /**
     * 持久化基本数据类型信息
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        //创建数据输出流实例
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));

        //数据输出流的存储
        dos.writeUTF("张三");//姓名
        dos.writeInt(20);//年龄
        dos.writeDouble(68.3);//体重
        dos.writeBoolean(true);//是否为男性
        dos.writeUTF("法外狂徒——张三！");


        dos.close();
    }

    /**
     * 读取持久化的基本数据类型
     */
    @Test
    public void test2() throws IOException {
        //创建数据输入流的实例
        DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
        //读取信息
        String name = dis.readUTF();
        int age = dis.readInt();
        double tiZhong = dis.readDouble();
        boolean isMan = dis.readBoolean();
        String jieShao = dis.readUTF();
        System.out.println(name + " " + age + " " + tiZhong + " " + isMan + " " + jieShao);
        //关闭流
        dis.close();
    }


}
