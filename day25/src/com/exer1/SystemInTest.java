package com.exer1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO 从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续
 *                      进行输入操作，直至当输入“e”或者“exit”时，退出程序。
 * @Date 2021-06-16 22:16
 */
public class SystemInTest {

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            //将输入字节流转换成输入字符流
            InputStreamReader isr = new InputStreamReader(System.in);
            //使用字符处理流readline方法来读取一行数据。
            br = new BufferedReader(isr);
            while (true) {
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {

                    System.out.println("退出成功！");
                    break;
                }
                System.out.println(data.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
