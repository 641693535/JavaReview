package com.exer1;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description 单例模式：饿汉式
 * @Date 2021-05-31 20:47
 */
public class EHanTest {
    private EHanTest(){
    }
    private static EHanTest eHanTest = new EHanTest();
    public static EHanTest getEHanTest(){
        return eHanTest;
    }
}
