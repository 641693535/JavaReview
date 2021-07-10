package com.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-08 14:43
 */
public class ForeachTest {
    @Test
    public void test1(){
        ArrayList arr = new ArrayList();
        arr.add(123);
        String[] s = new String[]{"AA", "BB", "CC", "DD", "GG"};
        int[] i = new int[]{123,234,1121};
        arr.addAll(Arrays.asList(s));
        arr.add(new String("Tom"));
        arr.addAll(Arrays.asList(i));
        for (Object o : arr) {
            System.out.println(o);
        }
    }
    @Test
    public void test2(){
        String[] s = new String[]{"AA", "BB", "CC", "DD", "GG"};

        for (String s1 : s) {
            System.out.println(s1);
        }

    }
}
