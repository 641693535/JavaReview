package com.java2;

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO 通过URL网络编程下载图片
 * @Date 2021-06-19 0:03
 */
public class URLTest {

    @Test
    public void client(){
        HttpURLConnection urlConnection = null;
        BufferedOutputStream bos = null;
        InputStream is = null;

        try {
            //获取URL
            URL url = new URL("https://img.onlinedown.net/download/202105/154535-60939e9fa3cc7.jpg");
            //通过URL获取URL连接管道
            urlConnection = (HttpURLConnection) url.openConnection();
            //通过获取到的连接管道进行真实的第一次连接
            urlConnection.connect();
            //创建输出流，用来保存连接获取到的数据。
            bos = new BufferedOutputStream(new FileOutputStream("QQLog.jpg"));
            //获取URL连接后得到的数据
            is = urlConnection.getInputStream();
            byte[] b = new byte[1024];
            int len;
            while ((len = is.read(b)) != -1) {
                bos.write(b, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                //关闭所有连接
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                urlConnection.disconnect();
            }
        }
    }

}
