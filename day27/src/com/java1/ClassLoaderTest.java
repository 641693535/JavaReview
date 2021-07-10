package com.java1;

import org.junit.Test;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-19 16:12
 */
public class ClassLoaderTest {

    @Test
    public void test1(){
        //获取加载器，此处获取到的是系统类加载器
        ClassLoader classLoader = GetClassTest.class.getClassLoader();
        System.out.println(classLoader);
        //通过加载器获取上一层加载器，此处获取到的是扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        //通过加载器获取上一层加载器，引导类加载器（核心加载器）获取不到，所以是null
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);
    }

}
