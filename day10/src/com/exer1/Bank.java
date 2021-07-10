package com.exer1;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-05-25 22:17
 */
public class Bank {
    private Customer[] customers = new Customer[10];
    private int numberOfCustomer;

    public Bank() {
    }

    public void addCustomer(String f, String l) {
        customers[numberOfCustomer++] = new Customer(f, l);
    }

    public Customer getCustomer(int index) {
        if(index >= 0 && index < numberOfCustomer)
            return customers[index];
        else
            return null;
    }

    public int getNumberOfCustomer() {
        return numberOfCustomer;
    }
}
