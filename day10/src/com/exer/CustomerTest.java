package com.exer;

import java.util.Scanner;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-05-25 20:57
 */
public class CustomerTest {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        CustomerTest customerTest = new CustomerTest();
        System.out.print("请输入该用户的姓:");
        String lastName = scan.next();
        System.out.print("请输入该用户的名:");
        String firstName = scan.next();
        Customer c1 = new Customer(firstName, lastName);
        c1.setAccount(new Account(1000, 1000, 1.23));
        customerTest.deposit(c1);
        customerTest.take(c1);
        customerTest.take(c1);
        c1.show();
    }

    public void deposit(Customer c) {
        System.out.print("请输入需要存款的金额：");
        double amount = scan.nextDouble();
        c.getAccount().deposit(amount);
    }

    public void take(Customer customer) {
        System.out.print("请输入需要取款的金额：");
        double takeAmount = scan.nextDouble();
        customer.getAccount().withdraw(takeAmount);
    }
}