package com.java1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO 创建多线程的方式三：实现Callable接口，用FutureTask(Callable)
 *                  接着Thread(futureTask).start();来运行
 *                  futrureTask.get()接收Callable实现类返回的值
 * @Date 2021-06-04 23:38
 */
public class CallableTest {
    public static void main(String[] args) {
        CalTest cal = new CalTest();
        FutureTask futureTask = new FutureTask(cal);
        Thread t1 = new Thread(futureTask);
        t1.start();

        Object o = null;
        try {
            o = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("总和为：" + o);
    }
}
class CalTest implements Callable{

    int sum = 0;
    @Override
    public Object call() throws Exception {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
            sum += i;
        }
        return sum;
    }
}
