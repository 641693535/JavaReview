package com.java1;

import java.io.File;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-13 22:46
 */
public class FileNameTest {

    private Long fileSize = 0l;

    /**
     *  遍历指定目录所有文件名称，包括子文件目录中的文件。
     * 拓展1：并计算指定目录占用空间的大小
     * 拓展2：删除指定文件目录及其下的所有文件
     */
    public static void main(String[] args) {
        FileNameTest fnt = new FileNameTest();

        File file = new File("E:\\workspace\\workspace-java\\workspace-java-idea\\JavaReview\\Project03-1");

        fnt.showName(file);
        System.out.println("fileSize文件总大小为(byte):" + fnt.fileSize);
    }

    public void showName(File file){
        File[] files = file.listFiles();

        for (File f : files) {
            if (f.isDirectory()) {
                showName(f);
            }else {
                System.out.println(f.getName());
                fileSize += f.length();

            }
        }
    }


}
