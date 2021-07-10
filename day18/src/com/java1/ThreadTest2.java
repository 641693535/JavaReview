package com.java1;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO 同步方法解决继承的线程安全问题
 * @Date 2021-06-04 14:19
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        Thread2 t1 = new Thread2();
        Thread2 t2 = new Thread2();
        Thread2 t3 = new Thread2();
        t1.start();
        t2.start();
        t3.start();
    }
}
class Thread2 extends Thread{
    private static int ticket = 100;//票数
    public void run(){
        while (ticket > 0) {
            show();
        }
    }
    private static synchronized void show(){
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖出，票号为：" + ticket);
            ticket--;
        }

    }
}

