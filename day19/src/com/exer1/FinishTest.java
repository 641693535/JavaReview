package com.exer1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO 三天打鱼，两天晒网。2000-01-01开始。
 * @Date 2021-06-06 17:51
 */
public class FinishTest {
    public static void main(String[] args) throws ParseException {
        final String s1 = "2000-01-01";
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入需要计算的日期(xxxx-xx-xx)：");
        String newStr = scan.next();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(s1);
        Date parse1 = sdf.parse(newStr);
        long l = (parse1.getTime() - parse.getTime()) / (1000 * 60 * 60 *24) + 1;
        Date date = new Date(l);
        System.out.println(l);
        if (l % 5 > 3 || l % 5 == 0) {
            System.out.println("这一天正在晒网");
        }else{
            System.out.println("这一天正在打鱼！");
        }
    }
    public void suan(){

    }
}
