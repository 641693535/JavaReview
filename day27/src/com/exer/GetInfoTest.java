package com.exer;

import com.java2.Person;

import java.lang.reflect.Method;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-19 22:20
 */
public class GetInfoTest {

    public static void main(String[] args) throws Exception {

        Class<Person> person = (Class<Person>) Class.forName("com.java2.Person");
        Method info = person.getDeclaredMethod("info");
        info.setAccessible(true);
        Person person1 = new Person();
        Object inf = info.invoke(person1);
        if (inf != null) {
            System.out.println(inf);
        }

    }

}
