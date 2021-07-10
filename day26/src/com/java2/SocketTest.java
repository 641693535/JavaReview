package com.java2;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO 实现TCP的网络变成
 *                  客户端发送一条数据给服务端，服务端显示在控制台上
 * @Date 2021-06-18 20:06
 */
public class SocketTest {

    /**
     * 客户端
     */
    @Test
    public void client(){
        Socket cs = null;
        OutputStream os = null;
        try {
            cs = new Socket(InetAddress.getLocalHost().getHostName(), 65432);
            os = cs.getOutputStream();
            os.write("Hello，我是客户端~".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (cs != null) {
                try {
                    cs.close();
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
    public void server(){
        ServerSocket ss = null;
        Socket accept = null;
        InputStream is = null;
        ByteArrayOutputStream bos = null;
        try {
            ss = new ServerSocket(65432);
            accept = ss.accept();
            is = accept.getInputStream();


//            byte[] b = new byte[5];
//            int len;
//            while ((len = is.read(b)) != -1) {
//                System.out.print(new String(b, 0, len));
//            }

            bos = new ByteArrayOutputStream();
            byte[] b = new byte[5];
            int len;
            while ((len = is.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            System.out.println(bos.toString());
            System.out.println("收到了来自:" + accept.getInetAddress() + "的数据!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (accept != null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
