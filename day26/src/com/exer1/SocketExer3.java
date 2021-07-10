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
 * @Description TODO TCP:从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给
 *                          客户端。并关闭相应的连接。
 * @Date 2021-06-18 22:13
 */
public class SocketExer3 {

    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;
        ByteArrayOutputStream bos = null;

        try {
            //创建socket实例,并指明需要发送消息的目的端IP和端口号
            socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 9669);
            //通过socket获取输出流
            os = socket.getOutputStream();
            //通过socket获取的输出流，传出数据
            System.out.print("请输入要向" + socket.getInetAddress().getHostAddress() + "传输的数据：");
            Scanner scan = new Scanner(System.in);
            String str = scan.next();
            os.write(str.getBytes());
            //关闭数据的输出（关闭输出流）
            socket.shutdownOutput();
            //上述已发送完毕，下面开始接收服务端返回的消息
            is = socket.getInputStream();
            bos = new ByteArrayOutputStream();
            int len;
            byte[] b = new byte[1024];
            while ((len = is.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            System.out.println(bos.toString());
            //关闭数据的输入（关闭输入流）
            socket.shutdownInput();
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
            if (os != null) {
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
        OutputStream os = null;
        try {
            //创建服务端的服务Socket，并指明端口号
            serverSocket = new ServerSocket(9669);
            //获取服务Socket的Socket实例
            socket = serverSocket.accept();
            //通过socket获取输入流
            is = socket.getInputStream();
            //创建将数据保存到本地的输出流
            File file = new File(socket.getInetAddress().getHostAddress() + ".txt");
            bos = new BufferedOutputStream(new FileOutputStream(file, true));
            //读取socket获取输入流中的数据
            byte[] b = new byte[1024];
            int len;
            while ((len = is.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            //关闭数据的输入（关闭输入流）
            socket.shutdownInput();

            System.out.println("收到一条来自" + socket.getInetAddress().getHostAddress() +
                    "的数据，已保存在" + file.getName() + "文件中~");
            //返回"发送成功"给客户端
            os = socket.getOutputStream();
            os.write("发送成功".getBytes());
            //关闭数据的输出（关闭输出流）
            socket.shutdownOutput();
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
