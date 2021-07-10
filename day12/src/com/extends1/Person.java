package com.extends1;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-05-26 23:15
 */
public class Person {

    String name;
    int age;

    public Person() {
        System.out.println("这是一个Person的空构造器！");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat(){
        System.out.println("人吃饭");
        show();
    }
    public void eat(int i1) {

    }
    private void show(){
        System.out.println("我是一个人");
    }
}
