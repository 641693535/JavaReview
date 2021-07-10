package com.java1;

import java.util.concurrent.*;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO 创建多线程的方式四：线程池
 * @Date 2021-06-04 23:52
 */
public class ExecutorsTest {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(5);

//        Executors1 executors1 = new Executors1();
//        service.execute(executors1);

        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;

        Executors1 executors1 = new Executors1();
        service1.execute(executors1);

        SubmitTest submitTest = new SubmitTest();
        Future<?> submit = service1.submit(submitTest);

        try {
            System.out.println("总和为：" + submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        service.shutdown();
    }

}
class Executors1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
class SubmitTest implements Callable{

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                sum += i;
            }
        }
        return sum;
    }
}
