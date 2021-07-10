package com.java1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-08 14:20
 */
public class IteratorTest {
    public static void main(String[] args) {
        ArrayList arr = new ArrayList();
        arr.add(123);
        String[] s = new String[]{"AA", "BB", "CC", "DD", "GG"};
        int[] i = new int[]{123,234,1121};
        arr.addAll(Arrays.asList(s));
        arr.add(new String("Tom"));
        arr.addAll(Arrays.asList(i));
        //遍历数组
//        for(String a : s){
//            System.out.println(a);
//        }
        arr.remove("Tom");
        //遍历ArrayList
        Iterator iterator = arr.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
