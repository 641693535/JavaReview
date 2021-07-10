package com.exer1;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-05-25 22:23
 */
public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addCustomer("Jane", "Smith");
        Account ac1 = new Account(2000);
        Customer c1 = bank.getCustomer(0);
        c1.setAccount(ac1);
        c1.getAccount().withdraw(2100);
        System.out.println(bank.getNumberOfCustomer());
}
}
