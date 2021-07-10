package com.java2;

import org.junit.Test;

import java.io.*;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-16 0:00
 */
public class FileCopyTest {

    @Test
    public void test1(){

        String srcPath = "C:\\Users\\64169\\Desktop\\3_软件.zip";
        String destPath = "C:\\Users\\64169\\Desktop\\3_软件1.zip";

        long start = System.currentTimeMillis();

        copyFileTest(srcPath, destPath);

        long end = System.currentTimeMillis();
        System.out.println("复制总花费时间为:" + (end - start));//6448
    }

    public void copyFileTest(String srcPath, String destPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            byte[] b = new byte[1024];
            int len;
            while ((len = fis.read(b)) != -1) {
                fos.write(b, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Buffder
     */
    @Test
    public void test2() {

        String src = "C:\\Users\\64169\\Desktop\\3_软件.zip";
        String dest = "C:\\Users\\64169\\Desktop\\Copy_软件.zip";

        long start = System.currentTimeMillis();

        boolean isCopy = BufferedCopyTest(src, dest);
        if (isCopy) {
            System.out.println("复制成功！");
        }else{
            System.out.println("复制失败！");
        }

        long end = System.currentTimeMillis();

        System.out.println("总花费时间为：" + (end - start));//1154

    }
    public boolean BufferedCopyTest(String srcPath,String destPath) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] b = new byte[1024];
            int len;
            while ((len = bis.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            return true;
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
        return false;
    }

}
