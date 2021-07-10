package com.exer1;

import org.junit.Test;

import java.io.*;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-16 16:21
 */
public class AddPWDTest {
    /**
     * 加密图片
     */
    @Test
    public void test1() {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File destFile = new File("爱情与友情-加密后.jpg");

            bis = new BufferedInputStream(new FileInputStream("爱情与友情.jpg"));
            bos = new BufferedOutputStream(new FileOutputStream(destFile));

//            int len;
//            while ((len = bis.read()) != -1) {
//                bos.write(len ^ 5);
//            }

            byte[] b = new byte[1024];
            int len;
            while ((len = bis.read(b)) != -1) {
                for (int i = 0; i < len; i++) {
                    b[i] ^= 5;
                }
                bos.write(b,0,len);
            }

            System.out.println("复制加密成功,文件名为:" + destFile.getName());
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
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    /**
     * 解密图片
     */
    @Test
    public void test2() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File destFile = new File("爱情与友情-解密后.jpg");

            bis = new BufferedInputStream(new FileInputStream(new File("爱情与友情-加密后.jpg")));
            bos = new BufferedOutputStream(new FileOutputStream(destFile));

            int len;
            while ((len = bis.read()) != -1) {
                    bos.write(len ^ 5);
            }
            System.out.println("复制解密成功,文件名为:" + destFile.getName());
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
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
