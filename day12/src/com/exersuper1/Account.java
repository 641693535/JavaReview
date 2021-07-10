package com.exersuper1;

import org.junit.Test;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-05-27 19:01
 */
public class Account {
    private int id;//账号
    private double balance;//余额
    private double annuallnterestRate;//年利率

    public Account(int id, double balance, double annuallnterestRate) {
        this.id = id;
        this.balance = balance;
        this.annuallnterestRate = annuallnterestRate;
    }

    /**
     * @return 返回账号
     */
    public int getId() {
        return id;
    }

    /**
     * @return 返回余额
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @return 返回年利率
     */
    public double getAnnuallnterestRate() {
        return annuallnterestRate;
    }

    /**
     * @param id 设置账号
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param balance 设置余额
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * @param annuallnterestRate 设置年利率
     */
    public void setAnnuallnterestRate(double annuallnterestRate) {
        this.annuallnterestRate = annuallnterestRate;
    }

    /**
     * 获取月利率
     *
     * @return 返回月利率（%）
     */
    public double getMonthlyInterest() {
        return this.annuallnterestRate / 12.0;
    }

    /**
     * 提款方法
     *
     * @param amount 取款金额
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("您输入的取款金额有误！");
            return;
        } else if (amount > balance) {
            System.out.println("余额不足！");
            return;
        }
        balance -= amount;
        System.out.println("成功取出：" + amount + "元！");
    }

    /**
     * 存款方法
     *
     * @param amount 存款金额
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("您输入的存款金额有误！");
            return;
        }
        balance += amount;
        System.out.println("成功存入:" + amount + "元！");
    }

    public static void main(String[] args) {
        Account account = new Account(1122, 20000, 0.045);
        account.withdraw(30000);
        System.out.println("您的账户余额为:" + account.getBalance());
        account.withdraw(2500);
        account.deposit(3000);
        System.out.println("您的账户余额为:" + account.getBalance());
        System.out.println("月利率为:" + account.getMonthlyInterest());

    }

}
