package com.exersuper1;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-05-27 19:19
 */
public class CheckAccount extends Account{
    private double overdraft;//代表可透支额度


    public CheckAccount(int id, double balance, double annuallnterestRate, double overdraft) {
        super(id, balance, annuallnterestRate);
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance()) {
            super.withdraw(amount);
        } else if(amount - getBalance() <= overdraft){
            overdraft -= amount - getBalance();
//            setBalance(0);
            super.withdraw(getBalance());

        }else{
            System.out.println("超过您的可透支额度!");
        }
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    public static void main(String[] args) {

        Object s1 = new String("123");
        System.out.println(s1.toString());
        String s2 = new String("333");
        System.out.println(s2.toString());
        int i = Integer.parseInt(s2);
        System.out.println(i);
        CheckAccount ca = new CheckAccount(1122, 20000, 0.045, 5000);
        ca.withdraw(5000);
        System.out.println("您的账户余额:" + ca.getBalance());
        System.out.println("您的可透支额:" + ca.getOverdraft());

        ca.withdraw(18000);
        System.out.println("您的账户余额:" + ca.getBalance());
        System.out.println("您的可透支额:" + ca.getOverdraft());

        ca.withdraw(3000);
        System.out.println("您的账户余额:" + ca.getBalance());
        System.out.println("您的可透支额:" + ca.getOverdraft());
    }
}
