package com.java1;

import org.junit.Test;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO 获取Class实例的几种方式
 * @Date 2021-06-19 15:24
 */
public class GetClassTest {

    @Test
    public void test1(){
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        Person person = new Person();
        Class clazz2 = person.getClass();
        System.out.println(clazz2);

        Class clazz3 = null;
        try {
            clazz3 = Class.forName("com.java1.Person");
            System.out.println(clazz3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2 == clazz3);

        ClassLoader classLoader = GetClassTest.class.getClassLoader();
        Class clazz4 = null;
        try {
            clazz4 = classLoader.loadClass("com.java1.Person");
            System.out.println(clazz4);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(clazz1 == clazz4);

    }
}
