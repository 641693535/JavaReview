package com.java1;

import java.io.File;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-13 22:59
 */
public class DeleteFileTest {
    /**
     * 删除指定文件目录及其下的所有文件
     * @param args
     */
    public static void main(String[] args) {
        File file = new File("E:\\workspace\\workspace-java\\workspace-java-idea\\JavaReview\\day24\\io");

        DeleteFileTest deleteFileTest = new DeleteFileTest();

        deleteFileTest.deleteFile(file);

    }

    public void deleteFile(File file){

        File[] files = file.listFiles();

        for (File f : files) {
            if (f.isDirectory()) {
                deleteFile(f);
            }else{
                f.delete();
            }
        }
        file.delete();
    }
}
