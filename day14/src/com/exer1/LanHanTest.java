package com.exer1;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description 懒汉式
 * @Date 2021-05-31 20:49
 */
public class LanHanTest {
    private LanHanTest(){}

    private static LanHanTest lanHanTest = null;

    public static LanHanTest getLanHanTest(){
        if (lanHanTest == null) {
            lanHanTest = new LanHanTest();
        }
        return lanHanTest;
    }
}
