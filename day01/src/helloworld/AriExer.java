package helloworld;

import java.util.Scanner;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2020-11-29 22:32
 */
public class AriExer {

    public static void main(String[] args) {
        int ge,shi,bai;
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.print("请输入一个三位数的整数:");
            int threeNum = scan.nextInt();
            if(threeNum>999 || threeNum <100){
                System.out.println("您输入的不是三位数，请重新输入！");
                continue;
            }
            bai = threeNum / 100;
            //shi = (threeNum - bai * 100) / 10;
            shi = threeNum % 100 / 10;
            ge = threeNum % 10;
            System.out.println("您输入的个位为：" + ge + ",十位为：" + shi + ",百位为：" + bai);
            return;
        }
    }

}
