package com.exer1;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO 获取两个字符串中最大相同子串。比如：
 *                      str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
 *                      提示：将短的那个串进行长度依次递减的子串与较长的串比较。
 * @Date 2021-06-06 12:53
 */
public class SelectTest {
    public static void main(String[] args) {
        String str1 = "abcwerthelloyuiodef";
        String str2 = "cvhellobnm";

        SelectTest selectTest = new SelectTest();
        String s = selectTest.selectStr(str1, str2);
        System.out.println(s);

    }

    public String selectStr(String s1, String s2) {
        String maxStr = (s1.length() > s2.length())? s1 : s2;
        String minStr = (s1.length() > s2.length())? s2 : s1;

        String max = "";

        for (int i = 0; i < minStr.length() - 1; i++) {
            for (int j = minStr.length() - 1; j > i; j--) {
                String substring = minStr.substring(i, j);

//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                if (maxStr.contains(substring)) {
                    if (substring.length() > max.length()) {
                        max = substring;
                    }
                }
            }
        }
        return max;

    }
}
