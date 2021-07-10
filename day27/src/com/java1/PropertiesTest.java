package com.java1;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO 读取properties的两种方式
 * @Date 2021-06-19 17:09
 */
public class PropertiesTest {

    /**
     * 方式一：使用文件流的方式加载文件数据
     */
    @Test
    public void test1(){
        FileInputStream fis = null;
        try {
            //方式一：
            Properties prop = new Properties();
            fis = new FileInputStream("src\\jdbc.properties");
            prop.load(fis);
            String user = prop.getProperty("user");
            String miaoshu = prop.getProperty("miaoshu");
            System.out.println("user = " + user + ",miaoshu = " + miaoshu);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    /**
     * 方式二:通过类的加载器来获取输入流。
     * 区别：默认路径再src下
     */
    @Test
    public void test2(){
        InputStream is = null;
        try {
            Properties properties = new Properties();
            ClassLoader classLoader = PropertiesTest.class.getClassLoader();
            is = classLoader.getResourceAsStream("jdbc.properties");
            properties.load(is);

            String user = properties.getProperty("user");
            String miaoshu = properties.getProperty("miaoshu");

            System.out.println("user = " + user + ",miaoshu = " + miaoshu);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
