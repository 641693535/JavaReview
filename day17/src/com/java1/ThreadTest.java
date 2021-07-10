package com.java1;

/**
 * 多线程方式一：继承于Thread类的方式
 *
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-03 21:20
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        for (int i = 0; i < 101; i++) {
            System.out.println("*********");
        }
    }
}
class MyThread extends Thread{

    @Override
    public void run(){
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
