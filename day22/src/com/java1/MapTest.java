package com.java1;

import org.junit.Test;

import java.util.*;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-10 20:35
 */
public class MapTest {
    @Test
    public void test1(){
        Map map = new HashMap();

        map.put("AA", 123);
        map.put("BB", 456);
        map.put("CC", 123);
        map.put("DD", null);
        map.put("CC", new String("CCCCC"));

        System.out.println(map);

        //遍历所有的Key
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //遍历所有的Value
        Collection values = map.values();
        for (Object o : values) {
            System.out.println(o);
        }
        //获取Key-Value
        Set entrySet = map.entrySet();
        iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }

        //方式二：
        Set keySet = map.keySet();
        Iterator i1 = keySet.iterator();
        while (i1.hasNext()) {
            Object key = i1.next();
            Object value = map.get(key);
            System.out.println(key + "----" + value);
        }

    }
}
