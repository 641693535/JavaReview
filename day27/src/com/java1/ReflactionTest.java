package com.java1;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-19 14:12
 */
public class ReflactionTest {
    /**
     * 使用反射之前，不能调用Private方法
     */
    @Test
    public void test1() {
        //创建类的对象
        Person person = new Person("Tom", 12);
        //调用类的方法
        String name = person.getName();
        System.out.println(name);
        person.show();
        //调用类的属性
        person.age = 20;
        //调用类的toString
        System.out.println(person.toString());
    }

    /**
     * 通过反射，调用以上方法
     */
    @Test
    public void test2() {
        try {
            //创建类的对象
            Class clazz = Person.class;
            Constructor cons = clazz.getConstructor(String.class, int.class);
            Object jarry = cons.newInstance("Jarry", 18);
            System.out.println(jarry.toString());

            //调用类的属性
            Field age = clazz.getDeclaredField("age");
            age.set(jarry, 108);
            System.out.println(jarry.toString());
            //调用类的方法\构造器
            //调用方法
            Method show = clazz.getDeclaredMethod("show");
            show.invoke(jarry);
            //调用私有构造器
            Constructor cons1 = clazz.getDeclaredConstructor(String.class);
            cons1.setAccessible(true);
            Object jack = cons1.newInstance("Jack");
            System.out.println(jack.toString());
            //调用私有的方法并获取返回值
            Method showNation = clazz.getDeclaredMethod("showNation", String.class);
            showNation.setAccessible(true);
            Object nation = showNation.invoke(jack, "中国");
            System.out.println(nation.toString());


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
        }

    }

}
