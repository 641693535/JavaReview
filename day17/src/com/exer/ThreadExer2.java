package com.exer;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-04 0:05
 */
public class ThreadExer2 {
    public static void main(String[] args) {
        MyThread2 mt2 = new MyThread2();
        Thread t1 = new Thread(mt2);
        Thread t2 = new Thread(mt2);
        Thread t3 = new Thread(mt2);
        Thread t4 = new Thread(mt2);
        Thread t5 = new Thread(mt2);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

}
class MyThread2 implements Runnable{
    private int ticket = 100;
    SynchronizedTest s = new SynchronizedTest();
    @Override
    public void run() {
        synchronized (s) {
            while (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出，票号为：" + ticket);
                ticket--;
            }
        }
    }
}
class SynchronizedTest{
    public void te(){}
}
