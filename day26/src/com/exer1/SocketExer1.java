package com.exer1;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO TCP方式：客户端发送内容给服务端，服务端将内容打印到控制台上。
 * @Date 2021-06-18 21:39
 */
public class SocketExer1 {
    /**
     * 客户端
     */
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        try {
            //创建Socket实例，指定ip端口信息
            socket = new Socket(InetAddress.getLocalHost().getHostName(), 65432);
            //通过socket实例的输出流
            os = socket.getOutputStream();
            //通过输出流写出需要传递的数据
            System.out.print("请输入需要向" + socket.getInetAddress().getHostAddress() + "的" +
                    socket.getPort() + "端口传递的数据:");
            Scanner scan = new Scanner(System.in);
            String next = scan.next();
            os.write(next.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    //关闭连接
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 服务端
     */
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream bos = null;
        try {
            //创建服务Socket端，指明服务端口号
            serverSocket = new ServerSocket(65432);
            //获取socket实例
            socket = serverSocket.accept();
            //获取socket实例的输入流
            is = socket.getInputStream();
            //显示出输入流获取到的信息
            bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int len;
            while ((len = is.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            System.out.println(bos.toString());
            System.out.println("收到一条来自" + socket.getInetAddress().getHostAddress() + "的消息！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
