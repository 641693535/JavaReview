package com.java1;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-06 16:06
 */
public class SimpleDateTest {
    @Test
    public void SimpleDateFormatTest() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = sdf.format(new Date());
        Date d1 = new java.sql.Date(15615641324545L);
        System.out.println(d1);
        System.out.println(format);
        Date parse = sdf.parse("2021-06-07 17:05:00");
        System.out.println(parse);
    }
    /*
    将“2020-09-08”转换为java.sql.Date；
     */
    @Test
    public void test2() throws ParseException {
        String s1 = "2021-06-07";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(s1);
        java.sql.Date date = new java.sql.Date(parse.getTime());
        System.out.println(date);

    }

}
