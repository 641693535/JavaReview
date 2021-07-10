package com.java1;

import org.junit.Test;

import java.io.*;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO 对象流
 * @Date 2021-06-17 22:04
 */
public class ObjectInputOutputStreamTest {

    /**
     * 创建输出对象流
     */
    @Test
    public void test1(){
        ObjectOutputStream oos = null;
        try {
            //创建对象流的实例
            oos = new ObjectOutputStream(new FileOutputStream("Object.dat"));
            //调用对象流实例的方法，写入数据
            oos.writeObject(new String("别看我只是一只羊~"));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * 创建输入对象流
     */
    @Test
    public void test2() {
        ObjectInputStream ois = null;

        try {
            //创建对象流输入的实例
            ois = new ObjectInputStream(new FileInputStream("Object.dat"));


            //通过对象流读取数据
            Object object = ois.readObject();
            if (object instanceof String) {
                String str = (String) object;
                System.out.println(str);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


    }
}
