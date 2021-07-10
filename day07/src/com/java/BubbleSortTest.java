package com.java;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO排序
 * @Date 2021-05-22 16:44
 */
public class BubbleSortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{34, 5, 22, -98, 6, -76, 0, -3};

        //冒泡排序
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        //反转数组
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        //复制数组
        int[] arr1 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[i];
        }
//        线性查找
        int selectNum = 22;
        boolean isSelect = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == selectNum) {
                System.out.println("已经找到，索引位置在：" + i);
                isSelect = false;
                break;
            }
        }
        if (isSelect) {
            System.out.println("未找到！");
        }
        //输出
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
    }
}
