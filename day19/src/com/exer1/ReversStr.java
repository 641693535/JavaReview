package com.exer1;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”
 * @Date 2021-06-06 1:27
 */
public class ReversStr {

    public static void main(String[] args) {
        ReversStr reversStr = new ReversStr();
        String s = "abcdefg";

        String revers = reversStr.revers(s, 2, 5);
        System.out.println(revers);

    }

    public String revers(String s, int top, int end) {
        if (s.isEmpty()) {
            return s;
        }
        if (top < 0 || end >= s.length()) {
            System.out.println("输入的反转范围错误！");
            return s;
        }
        String newStr = s;
        String startStr = newStr.substring(0, top);
        String endStr = newStr.substring(end + 1);
        String revStr = newStr.substring(top, end + 1);
        char[] chars = revStr.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1];
            chars[chars.length - 1] = temp;
        }
        newStr = startStr + new String(chars) + endStr;
        return newStr;
    }

}
