package com.exer1;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-08 20:42
 */
public class EmployeeTest {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        ts.add(new Employee("ZhangSan", 17, new MyDate(2001, 11, 11)));
        ts.add(new Employee("LiSi", 32, new MyDate(1989, 12, 21)));
        ts.add(new Employee("WangWu", 20, new MyDate(1999, 6, 30)));
        ts.add(new Employee("XiaoMing", 30, new MyDate(1991, 10, 7)));
        ts.add(new Employee("MaiKe", 32, new MyDate(1989, 12, 22)));

        Iterator iterator = ts.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("*****************************");

        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    MyDate b1 = e1.getBirthday();
                    MyDate b2 = e2.getBirthday();
                    //比较年
                    int compare = Integer.compare(b1.getYear(), b2.getYear());
                    if (compare != 0) {
                        return compare;
                    }
                    //比较月
                    int compare1 = Integer.compare(b1.getMouth(), b2.getMouth());
                    if (compare1 != 0) {
                        return compare1;
                    }
                    //比较日
                    return Integer.compare(b1.getDay(), b2.getDay());
                }
                throw new RuntimeException("类型不一致！");

            }
        });
        treeSet.add(new Employee("ZhangSan", 17, new MyDate(2001, 11, 11)));
        treeSet.add(new Employee("LiSi", 32, new MyDate(1989, 12, 21)));
        treeSet.add(new Employee("WangWu", 20, new MyDate(1999, 6, 30)));
        treeSet.add(new Employee("XiaoMing", 30, new MyDate(1991, 10, 7)));
        treeSet.add(new Employee("MaiKe", 32, new MyDate(1989, 12, 22)));
        Iterator i1 = treeSet.iterator();
        while (i1.hasNext()) {
            System.out.println(i1.next());
        }
    }
}
