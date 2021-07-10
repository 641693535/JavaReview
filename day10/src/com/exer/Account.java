package com.exer;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-05-25 20:50
 */
public class Account {
    private int id;//id
    private double balance;//余额
    private double annuallnterestRate;//年利率

    public Account(int id, double balance, double annuallnterestRate) {
        this.id = id;
        this.balance = balance;
        this.annuallnterestRate = annuallnterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnuallnterestRate() {
        return annuallnterestRate;
    }

    public void setAnnuallnterestRate(double annuallnterestRate) {
        this.annuallnterestRate = annuallnterestRate;
    }
    public void withdraw (double amount){
        if (amount >= balance) {
            System.out.println("余额不足，取款失败");
        }else{
            System.out.println("成功取出:" + amount);
        }
    }//取钱
    public void deposit (double amount){
        balance += amount;
        System.out.println("成功存入:" + amount);
    }//存钱
}

