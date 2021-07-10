package com.java1;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO 懒汉式的线程安全写法
 * @Date 2021-06-04 20:01
 */
public class BankTest {

    public static void main(String[] args) {
        BankTe bank = new BankTe();
        Thread t1 = new Thread(bank);
        Thread t2 = new Thread(bank);
        Thread t3 = new Thread(bank);
        t1.start();
        t2.start();
        t3.start();
    }

}

class BankTe implements Runnable {

    @Override
    public void run() {
        System.out.println(Bank.getBank());
    }
}
class Bank{
    private Bank(){}

    private static Bank b = null;

    public static Bank getBank(){
        synchronized (Bank.class) {
            if (b == null) {
                b = new Bank();
            }
            return b;
        }
    }

}
