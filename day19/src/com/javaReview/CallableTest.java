package com.javaReview;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-05 16:17
 */
public class CallableTest {
    public static void main(String[] args) {
        CallTest callTest = new CallTest();
        FutureTask<Integer> integerFutureTask = new FutureTask<>(callTest);
        Thread t1 = new Thread(integerFutureTask);

        t1.start();

        try {
            Integer i = integerFutureTask.get();
            System.out.println(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

class CallTest implements Callable<Integer> {
    int sum = 0;
    @Override
    public Integer call() throws Exception {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                sum += i;
            }
        }
        return sum;
    }
}
