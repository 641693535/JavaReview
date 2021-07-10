package com.java2;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO UDP协议的网络编程
 * @Date 2021-06-18 23:41
 */
public class DatagramSocketTest {
    /**
     * 发送端
     */
    @Test
    public void send(){
        DatagramSocket socket = null;

        try {
            //创建UDPSocket实例
            socket = new DatagramSocket();
            //创建packet用于装数据并指明ip和端口
            System.out.print("请输入要UDP形式发送的数据：");
            Scanner scan = new Scanner(System.in);
            String str = scan.next();
            DatagramPacket packet = new DatagramPacket(str.getBytes(), str.length(), InetAddress.getLocalHost(), 9933);
            //使用socket实例发送数据包
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                //关闭流
                socket.close();
            }
        }
    }

    /**
     * 接收端
     */
    @Test
    public void receiver(){
        DatagramSocket socket = null;

        try {
            //创建UDPSocket实例
            socket = new DatagramSocket(9933);
            //创建保存数据的数组和packet实例，用于保存接收到的数据
            byte[] b = new byte[1024];
            DatagramPacket packet = new DatagramPacket(b, b.length);
            //读取数据
            socket.receive(packet);
            System.out.println(new String(packet.getData(), 0, packet.getLength()));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
