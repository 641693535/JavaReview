package com.exer;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-05-25 20:54
 */
public class Customer {
    private String firstName;
    private String lastName;
    private Account account;

    public Customer(String f, String l) {
        this.firstName = f;
        this.lastName = l;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    public void show(){
        System.out.println("Customer [" + this.firstName + ", " + this.lastName + "] has a account: id is " + account.getId() + "," +
                " annualInterestRate is " + account.getAnnuallnterestRate() + "%, balance is " + account.getBalance());
    }
}
