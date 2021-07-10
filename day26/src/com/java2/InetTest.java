package com.java2;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-18 15:13
 */
public class InetTest {

    public static void main(String[] args) {

        try {
            InetAddress inet1 = InetAddress.getByName("www.atguigu.com");

            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("localhost");

            System.out.println(inet2);

            InetAddress inet3 = InetAddress.getLocalHost();

            System.out.println(inet3);

            System.out.println(inet1.getHostName());
            System.out.println(inet1.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }

}
