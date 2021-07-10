package com.java;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-05-25 13:45
 */
public class ShuXingTest {
    public static void main(String[] args) {
        int i = 10;
        int m = i;
        System.out.println("i = " + i + ",m = " + m);
//        m = 20;
//        System.out.println("i = " + i + ",m = " + m);
        i = 20;
        System.out.println("i = " + i + ",m = " + m);
//        Customer c = new Customer();
        Customer c1 = new Customer(1, "Tom");
    }
}
class Customer{
    int id;
    String name;

    public Customer(){
        System.out.println("调用了空参构造器！");
    }

    public Customer(int id, String name) {
        this();
        this.id = id;
        this.name = name;
    }
}
