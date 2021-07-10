package com.exer1;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO 模拟一个trim方法，去除字符串两端的空格。
 * @Date 2021-06-06 0:58
 */
public class TrimTest {

    public static void main(String[] args) {

        TrimTest trimTest = new TrimTest();

        String s = "     ";

        String newStr = trimTest.trim(s);
        System.out.println(newStr);

    }

    public String trim(String s) {
        if (s.isEmpty()) {
            return s;
        }
        if (s.charAt(0) != ' ' && s.charAt(s.length() - 1) != ' ') {
            return s;
        }
        String newStr = s;
        System.out.println(newStr);
        char start = newStr.charAt(0);
        char end = newStr.charAt(newStr.length() - 1);
        while (true) {
            if (newStr.isEmpty()) {
                return newStr;
            }
            start = newStr.charAt(0);
            end = newStr.charAt(newStr.length() - 1);

            if (start == ' ') {
                newStr = newStr.substring(1);
            } else if (end == ' ') {
                newStr = newStr.substring(0, newStr.length() - 1);
            } else {
                return newStr;
            }
        }

    }

}
