package com.java1;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-12 0:08
 */
public class GenericTest {

    @Test
    public void test1(){
        HashMap<String, Integer> nameScore = new HashMap<>();
        nameScore.put("Jack", 100);
        nameScore.put("Jerry", 96);
        nameScore.put("Mack", 85);
        nameScore.put("Marry", 92);

        Set<Map.Entry<String, Integer>> entrySet = nameScore.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println(key + "-->" + value);
        }

    }

}
