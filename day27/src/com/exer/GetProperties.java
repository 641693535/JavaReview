package com.exer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-19 22:12
 */
public class GetProperties {

    public static void main(String[] args) throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("day27\\src\\jdbc.properties");
        prop.load(fis);

        String name = prop.getProperty("user");
        System.out.println("name = " + name);


        Properties prop1 = new Properties();
        ClassLoader classLoader = GetProperties.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        prop1.load(is);
        String name1 = prop1.getProperty("user");
        System.out.println("name1 = " + name1);

    }

}
