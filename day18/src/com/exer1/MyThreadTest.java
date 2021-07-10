package com.exer1;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-04 12:31
 */
public class MyThreadTest {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        t1.start();
    }
}
class Thread1 extends Thread{    
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + ":" + i);
        }
    }
}
