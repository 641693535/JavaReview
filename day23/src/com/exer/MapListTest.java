package com.exer;

import java.util.*;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO 遍历Map中的Key-value
 * @Date 2021-06-11 23:11
 */
public class MapListTest {

    public static void main(String[] args) {

        HashMap hashMap = new HashMap();
        hashMap.put("AA", 123);
        hashMap.put("BB", new String("args"));
        hashMap.put("CC", new Object());
        hashMap.put("DD", new Scanner(System.in));
        hashMap.put("EE", 789);
        hashMap.put("EE", 999);

        //方式一
//        Set entrySet = hashMap.entrySet();
//        Iterator iterator = entrySet.iterator();
//        while (iterator.hasNext()) {
//            Map.Entry en = (Map.Entry) iterator.next();
//            System.out.println(en.getKey() + "-->" + en.getValue());
//        }

        //方式二
//        Set keySet = hashMap.keySet();
//        Iterator iterator = keySet.iterator();
//        while (iterator.hasNext()) {
//            Object key = iterator.next();
//            Object values = hashMap.get(key);
//            System.out.println(key + "-->" + values);
//        }

    }

}
