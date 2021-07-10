package com.java;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-20 14:11
 */
public class LambdaTest {

    @Test
    public void test1(){

        Runnable t1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我在郑州");
            }
        };
        t1.run();

        System.out.println("***************");

        Runnable t2 = () -> System.out.println("我在新郑");

        t2.run();
    }

    @Test
    public void test2(){

        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        HashSet<Integer> integers = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            integers.add(nums[i]);
        }

        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; iterator.hasNext(); i++) {
            nums[i] = iterator.next();
        }
        System.out.println(integers.size());

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }

    @Test
    public void test3(){
        String s1 = "a12b";
        int i = Integer.parseInt(s1);
        System.out.println(i);
    }

}
