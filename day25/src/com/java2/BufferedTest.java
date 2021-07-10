package com.java2;

import java.io.*;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-16 16:00
 */
public class BufferedTest {

    public static void main(String[] args) {

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            File srcFile = new File("day25\\dbcp.txt");
            File destFile = new File("day25\\dbcp1.txt");

            br = new BufferedReader(new FileReader(srcFile));
            bw = new BufferedWriter(new FileWriter(destFile));
            //方法一：使用char[]
//            char[] cbuf = new char[10];
//            int len;
//            while ((len = br.read(cbuf)) != -1) {
//                bw.write(cbuf, 0, len);
//            }
            //方法二：使用String
            String strLine;
            while ((strLine = br.readLine()) != null) {
//                bw.write(strLine + "\n");//手动加上换行符
                bw.write(strLine);
                bw.newLine();
            }

            System.out.println("复制成功！");
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
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

}
