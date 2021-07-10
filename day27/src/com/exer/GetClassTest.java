package com.exer;

import com.java2.Person;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO 获取Class的几种方式
 * @Date 2021-06-19 22:00
 */
public class GetClassTest {
    public static void main(String[] args) throws ClassNotFoundException {

        Class<Person> personClass = Person.class;

        Class<?> personClass1 = Class.forName("com.java2.Person");

        Person person2 = new Person();
        Class<? extends Person> personClass2 = person2.getClass();
        Person person4 = new Person();
        Class<? extends Person> personClass4 = person4.getClass();

        ClassLoader classLoader = Person.class.getClassLoader();
        Class<?> personClass3 = classLoader.loadClass("com.java2.Person");

        System.out.println(personClass == personClass1);
        System.out.println(personClass == personClass2);
        System.out.println(personClass == personClass3);

        System.out.println(person2 == person4);
        System.out.println(personClass2 == personClass4);

    }
}
