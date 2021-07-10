package com.java1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-13 21:28
 */
public class FileTest {
    /**
     * 利用File构造器，new 一个文件目录file
     * 1)在其中创建多个文件和目录
     * 2)编写方法，实现删除file中指定文件的操作
     */
    @Test
    public void test1() throws IOException {
        File file1 = new File("E:\\workspace\\workspace-java\\workspace-java-idea\\JavaReview\\day24\\hello.txt");
        System.out.println(file1.getParent());
        File file2 = new File(file1.getParent());
        boolean newFile = new File(file2, "helloworld.txt").createNewFile();
        if (newFile) {
            System.out.println("创建成功！");
        }
        boolean delete = new File(file2, "helloworld.txt").delete();
        if (delete) {
            System.out.println("删除成功！");
        }

    }

    /**
     *  判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
     */
    @Test
    public void test2(){
        File file = new File("E:\\workspace\\workspace-java\\workspace-java-idea\\JavaReview\\day24\\io");
        String[] list = file.list();
        for (String s : list) {
//            if (s.contains(".jpg")) {
            if (s.endsWith(".jpg")) {
                System.out.println(s);
            }
        }
    }
}
