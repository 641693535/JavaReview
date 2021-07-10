package com.exer1;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-10 22:15
 */
/*
请把学生名与考试分数录入到集合中，并按分数显示前三名成绩学员的名字。
 */
public class ListTest2 {
    public static void main(String[] args) {
        Student s1 = new Student("小明", 87);
        Student s2 = new Student("张三", 100);
        Student s3 = new Student("王明", 67);
        Student s4 = new Student("李四", 92);
        Student s5 = new Student("杰克", 85);

        TreeSet<Student> treeSet = new TreeSet();
        treeSet.add(s1);
        treeSet.add(s2);
        treeSet.add(s3);
        treeSet.add(s4);
        treeSet.add(s5);

        Iterator<Student> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        int count = 0;
        for (Student student : treeSet) {
            if (count < 3) {
                System.out.println(student.getName() + "--->"
                        + student.getScore());
                count++;
            }
        }
    }
}
