package com.javaReview;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-05 16:24
 */
public class ExecutorsTest {
    public static void main(String[] args) {
        ExeTest exeTest = new ExeTest();
        ExecutorService service = Executors.newFixedThreadPool(5);
        service.execute(exeTest);

    }
}
class ExeTest implements Runnable{
    int sum = 0;
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
