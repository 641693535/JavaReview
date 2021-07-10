package com.java2;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-19 18:47
 */
public class GetMethodFieldTest {

    @Test
    public void test1(){

        Class<Person> p1 = Person.class;
        //获取所有Public方法，包括父类
        Method[] methods = p1.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }

        System.out.println("*************************");

        //获取该类所有的方法，不包括父类
        Method[] declaredMethods = p1.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(m);
        }

        System.out.println("****************************");
        //获取该类所有的Public构造器
        Constructor<?>[] constructors = p1.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }

        System.out.println("*************************");
        //获取该类所有的构造器
        Constructor<?>[] declaredConstructors = p1.getDeclaredConstructors();
        for (Constructor c : declaredConstructors) {
            System.out.println(c);
        }


        System.out.println("********获取所有的Public属性*******");
        Field[] fields = p1.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }

        System.out.println("********获取所有的属性********");
        Field[] declaredFields = p1.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println(f);
        }
    }

    @Test
    public void test2(){
        Class<Person> p = Person.class;
        Method[] declaredMethods = p.getDeclaredMethods();
        for (Method m : declaredMethods) {
            //获取注解
            Annotation[] annotations = m.getAnnotations();
            for (Annotation a : annotations) {
                System.out.print(a.toString() + '\t');
            }
            //获取类构造器的权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + '\t');
            //获取返回值
            System.out.print(m.getReturnType().getName() + '\t');
            //获取名字
            System.out.print(m.getName() + '(');
            //获取形参列表
            Class<?>[] parameterTypes = m.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                System.out.print(parameterTypes[i]);
                if (i < parameterTypes.length - 1) {
                    System.out.print(",");
                }

            }
            System.out.print(')');
            //获取异常
            Class<?>[] exceptionTypes = m.getExceptionTypes();
            if (exceptionTypes != null && exceptionTypes.length > 0) {
                System.out.print("throw ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    System.out.print(exceptionTypes[i]);
                    if (i < exceptionTypes.length - 1) {
                        System.out.print(",");
                    }
                }
            }

            System.out.println();

        }
    }
    /**
     * 获取类的注解
     */
    @Test
    public void test3(){
        Class p = Person.class;
        Annotation[] annotations = p.getAnnotations();
        for (Annotation a : annotations) {
            System.out.print(a);
        }

    }
}
