package com.exer2;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-04 22:10
 */
public class ProductorTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Productor p1 = new Productor(clerk);
        Customer c1 = new Customer(clerk);

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(c1);
        Thread t3 = new Thread(c1);

        t1.setName("生产者1");
        t2.setName("消费者1");
        t3.setName("消费者2");

        t1.start();
        t2.start();
        t3.start();
    }
}

/**
 * 生产者
 */
class Productor implements Runnable {
    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "：开始生产产品...");
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.productorProduct();
        }
    }
}

/**
 * 店员
 */
class Clerk {
    private int productNum = 20;

    //生产产品
    public synchronized void productorProduct() {
        if (productNum < 20) {

            productNum++;
            System.out.println(Thread.currentThread().getName() + "开始生产第" + productNum + "个产品。");
        } else {
            try {
                notify();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //消费产品
    public synchronized void customerProduct() {
        if (productNum > 0) {

            System.out.println(Thread.currentThread().getName() + "开始消费第" + productNum + "个产品。");
            productNum--;
        } else {
            try {
                notify();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

/**
 * 消费者
 */
class Customer implements Runnable {
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始消费产品...");
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.customerProduct();
        }
    }
}