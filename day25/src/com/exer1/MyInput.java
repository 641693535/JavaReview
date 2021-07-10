package com.exer1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO Create a program named MyInput.java: Contain the methods for reading int,
 *                      double, float, boolean, short, byte and String values from the keyboard.
 * @Date 2021-06-16 22:32
 */
public class MyInput {

    public MyInput(){}

    public static String readString() {
        try {
            //将键盘输入的字节数据转成字符
            InputStreamReader isr = new InputStreamReader(System.in);
            //将字符数据转换成可以读一行
            BufferedReader br = new BufferedReader(isr);
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static int readInt() {
        return Integer.parseInt(readString());
    }

    public static byte readByte(){
        return Byte.parseByte(readString());
    }

    public static short readShort(){
        return Short.parseShort(readString());
    }

    public static long readLong(){
        return Long.parseLong(readString());
    }

    public static float readFloat(){
        return Float.parseFloat(readString());
    }

    public static double readDouble(){
        return Double.parseDouble(readString());
    }


}
