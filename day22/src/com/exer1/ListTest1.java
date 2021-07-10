package com.exer1;

import java.util.*;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-10 22:02
 */
public class ListTest1 {

    /**
     * 从键盘输入10个整数保存到List中，并按照从大到小的顺序显示出来。
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List list = new ArrayList();
        System.out.println("请输入十个整数!");
        for (int i = 0; i < 10; i++) {
            System.out.print("请输入第" + (i+1) + "个:");
            int integer = scan.nextInt();
            list.add(integer);
        }
        System.out.print("输入成功，您输入的是：");
        System.out.println(list);

        //方式一：通过Collections工具类进行排序、反转操作
        Collections.sort(list);
        Collections.reverse(list);

//        方式二：通过工具类传入定制排序排序
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer && o2 instanceof Integer) {
                    int i1 = (Integer) o1;
                    int i2 = (Integer) o2;
                    return -(i1 - i2);
                }
                throw new RuntimeException("传入的类型不匹配！");
            }
        });
        System.out.println(list);
    }
}
