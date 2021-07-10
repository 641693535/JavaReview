package com.exer1;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO 获取一个字符串在另一个字符串中出现的次数。
 *                  比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
 * @Date 2021-06-06 1:46
 */
public class CountStr {
    public static void main(String[] args) {
        String s1 = "abkkcadkabkebfkabkskab";
        String s2 = "ab";
        CountStr countStr = new CountStr();
        int i = countStr.countStr(s1, s2);
        System.out.println(i);
    }

    public int countStr(String s1, String s2) {

        int count = 0,index = 0;

        while (true) {
            int indexOf = s1.indexOf(s2, index);
            index = indexOf + 1;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(index);
            if (indexOf >= 0) {
                count++;
            }else{
                return count;
            }
        }
    }
}
