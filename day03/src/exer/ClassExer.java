package exer;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2020-12-08 11:01
 */
public class ClassExer {
    @Test
    public void test1() {
        boolean x = true;
        boolean y = false;
        short z = 40;
        if ((z++ == 40) && (y = true)) {
            z++;
        }
        if ((x = false) || (++z == 43)) {
            z++;
        }
        System.out.println("z = " + z);
    }

    @Test
    public void test2() {
        /*3.	定义三个int型变量并赋值，使用三元运算符或者if-else获取这三个数中的较大数的实现*/
        int n1 = 28;
        int n2 = 42;
        int n3 = 88;
        int max = (n1 > n2) ? ((n1 > n3) ? n1 : n3) : ((n2 > n3) ? n2 : n3);
        if (n1 > n3 && n1 > n2) {
            max = n1;
        } else if (n2 > n3 && n2 > n1) {
            max = n2;
        } else {
            max = n3;
        }
        System.out.println(max);
    }

    @Test
    public void test3() {
        //4.编写程序，声明2个double型变量并赋值。
        // 判断第一个数大于10.0，且第2个数小于20.0，打印两数之和。否则，打印两数的乘积。
        double d1 = 3.14, d2 = 128.0;
        if (d1 > 10.0 && d2 < 20.0) {
            System.out.println(d1 + d2);
        } else {
            System.out.println(d1 * d2);
        }
    }

    @Test
    public void test4() {
        //交换两个变量值的代码的实现
        int n1 = 128, n2 = 1024;
        //方式一：
        int temp = n1;
        n1 = n2;
        n2 = temp;
        System.out.println("" + n1 + n2);
        //方式二：
        n1 = n1 ^ n2;
        n2 = n1 ^ n2;
        n1 = n2 ^ n1;
        System.out.println("" + n1 + n2);
    }
}
