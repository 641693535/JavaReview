package com.java1;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO 同步代码块解决线程安全问题
 * @Date 2021-06-04 14:19
 */
public class ThreadTest3 {
    public static void main(String[] args) {
        Thread3 th3 = new Thread3();
        Thread t1 = new Thread(th3);
        Thread t2 = new Thread(th3);
        Thread t3 = new Thread(th3);
        t1.start();
        t2.start();
        t3.start();
    }
}
class Thread3 implements Runnable{
    private static int ticket = 100;//总票数
    @Override
    public void run() {

        while (ticket > 0) {
            synchronized (this) {
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
    }
}
