package com.exer1;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-05-25 22:15
 */
public class Account {
    private double balance;

    public Account(double init_balance) {
        this.balance = init_balance;
    }

    public double getBalance() {
        return balance;
    }
    //存款
    public void deposit(double amt) {
        balance += amt;
        System.out.println("存款成功：" + amt);
    }
    //取款
    public void withdraw(double amt) {
        if (balance <= amt) {
            System.out.println("取款失败，余额不足！");
        }else{
            balance -= amt;
            System.out.println("取款成功:" + amt);
        }
    }
}
