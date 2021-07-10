package com.exer1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-04 20:46
 */
public class AccountLockTest {
    public static void main(String[] args) {
        Account account = new Account();
        Customer c1 = new Customer(account);
        Customer c2 = new Customer(account);
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前账户余额为：" + account.getBalance());
    }
}

class Customer implements Runnable {
    private Account a;
    public Customer(Account a){
        this.a = a;
    }
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a.addBanlance(1000);
            System.out.println(a.getBalance());
        }
    }
}
class Account{
    private int balance = 0;
    ReentrantLock lock = new ReentrantLock();
    public int getBalance() {
        return balance;
    }

    public void addBanlance(int balance){
        synchronized (this) {
            if(balance > 0)
                this.balance += balance;
        }
    }
}

