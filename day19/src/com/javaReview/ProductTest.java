package com.javaReview;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 *
 * @Date 2021-06-05 16:03
 */
public class ProductTest{
    public static void main(String[] args) {
        Clierk clierk = new Clierk();
        Productor productor = new Productor(clierk);
        Customer customer = new Customer(clierk);
        productor.start();
        customer.start();
    }
}

/**
 * 生产者
 */
class Productor extends Thread{
    Clierk clierk = null;

    public Productor(Clierk clierk) {
        this.clierk = clierk;
    }

    @Override
    public void run() {
        System.out.println("生产者开始生产产品...");
        while (true) {
            clierk.makeSomething();
        }
    }
}

/**
 * 店员
 */
class Clierk {
    private int something = 0;

    public synchronized void makeSomething(){
        if (something < 20) {
            something++;
            System.out.println(Thread.currentThread().getName() + "开始生产第" + something + "个产品.");
        }else{
            try {
                notify();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void getSomething(){
        if (something > 0) {
            System.out.println(Thread.currentThread().getName() + "开始消费第" + something + "个产品.");
            something--;
        }else{
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
class Customer extends Thread{
    Clierk clierk = null;

    public Customer(Clierk clierk) {
        this.clierk = clierk;
    }

    @Override
    public void run() {
        System.out.println("消费者开始消费产品...");
        while (true) {
            clierk.getSomething();
        }
    }
}