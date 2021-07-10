package com.exer1;

import java.util.Scanner;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-02 17:34
 */
public class EcmDefTest {
    public static void main(String[] args) {
        try {
            EcmDef ecmDef = new EcmDef();
            int one = Integer.parseInt(args[0]);
            int two = Integer.parseInt(args[1]);
            ecmDef.ecm(one, two);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
            System.out.println("您传递的参数非数字：" + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
//            e.printStackTrace();
            System.out.println("您传递的参数为空：" + e.getMessage());
        } catch (ArithmeticException e) {
//            e.printStackTrace();
            System.out.println("您传递的被除数为0：" + e.getMessage());
        } catch (FuShuException e) {
//            e.printStackTrace();
            System.out.println("您传递的有负数：" + e.getMessage());
        }
    }
}
class EcmDef{
    public void ecm(int i,int j){
        if (i < 0 || j < 0) {
            throw new FuShuException("请输入非负数!");
        }
        System.out.println("两个数相除的结果是：" + i / j);
    }
}

class FuShuException extends RuntimeException {
    static final long serialVersionUID = -7034897190745766939L;

    public FuShuException() {
    }

    public FuShuException(String message) {
        super(message);
    }
}
