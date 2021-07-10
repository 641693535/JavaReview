package com.exer1;

import org.junit.Test;

import java.io.*;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO 自定义一个类，实现可序列化
 * @Date 2021-06-17 22:24
 */
public class MyObjectDataTest {

    /**
     * 持久化自定义可序列化类
     */
    @Test
    public void test1(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("Person.dat"));

            oos.writeObject(new Person("张三", 30));

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
     * 读取自定义序列化类文件
     */
    @Test
    public void test2(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Person.dat"));

            Object object = ois.readObject();
            System.out.println(object instanceof Serializable);
            if (object instanceof Person) {
                Person p = (Person) object;
                System.out.println(p.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
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
