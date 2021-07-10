package com.exer1;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO 线程的通讯：两个线程交替运行打印1-100
 * @Date 2021-06-04 21:53
 */
public class CommunicationTest {
    public static void main(String[] args) {
        Communication ct = new Communication();

        Thread t1 = new Thread(ct);
        Thread t2 = new Thread(ct);

        t1.start();
        t2.start();
    }
}
class Communication implements Runnable{
    private int i = 0;
    @Override
    public void run() {
        while (i <= 100) {

            synchronized (this) {
                notify();

                if(i <= 100) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    i++;

                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}