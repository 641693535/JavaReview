package com.java1;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO 同步监视器解决继承的线程安全问题
 * @Date 2021-06-04 14:16
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread1 t2 = new Thread1();
        Thread1 t3 = new Thread1();
        t1.start();
        t2.start();
        t3.start();
    }
}
class Thread1 extends Thread{
    private static int ticket = 100;//票数
    public void run(){

        while (ticket > 0) {
            synchronized (Thread1.class) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖出，票号为：" + ticket);
                    ticket--;
                }else{break;}
            }
        }
    }
}
