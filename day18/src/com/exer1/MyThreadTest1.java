package com.exer1;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-04 12:33
 */
public class MyThreadTest1 {

    public static void main(String[] args) {
        Thread2 th2 = new Thread2();
        Thread t1 = new Thread(th2);
        Thread t2 = new Thread(th2);
        Thread t3 = new Thread(th2);
        t1.start();
        t2.start();
        t3.start();

    }

}
class Thread2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
