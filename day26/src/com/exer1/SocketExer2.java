package com.exer1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO TCP:客户端发送文件给服务端，服务端将文件保存在本地。
 * @Date 2021-06-18 21:39
 */
public class SocketExer2 {
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;

        try {
            //创建Socket实例
            socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 9969);
            //通过socket实例创建输出流
            os = socket.getOutputStream();
            //通过输出流写出数据
            System.out.print("请输入要向" + socket.getInetAddress().getHostAddress() + "传输的数据：");
            Scanner scan = new Scanner(System.in);
            String str = scan.next();
            os.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                //关闭流
                try {
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
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        BufferedOutputStream bos = null;
        try {
            //创建socket服务的实例并指明端口
            serverSocket = new ServerSocket(9969);
            //从服务socket中获取socket实例
            socket = serverSocket.accept();
            //从socket中获取输入流
            is = socket.getInputStream();
            //创建本地文件的输出流
            File file = new File(socket.getInetAddress().getHostAddress() + ".txt");
            FileOutputStream fos = new FileOutputStream(file,true);
            bos = new BufferedOutputStream(fos);
            //从输入流中获取数据
            byte[] b = new byte[1024];
            int len;
            while ((len = is.read(b)) != -1) {
                //将收到的数据写入到本地文件
                bos.write(b, 0, len);
            }
            bos.write("\n".getBytes());
            System.out.println("收到一条来自" + socket.getInetAddress().getHostAddress() + "的数据！已保存在" +
                    file.getName() + "中，请注意查看~");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                //关闭流
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
