package onetest;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2020-12-08 11:16
 */
public class TestClass {
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        System.out.print("请输入岳小鹏的期末成绩:");
//        int score = scan.nextInt();
//        String jiangli = "";
//        if(score == 100){
//            jiangli = "一辆BMW";
//        }else if(score >= 80 && score <= 99){
//            jiangli = "一台iPhone";
//        }else if(score >= 60 && score< 80){
//            jiangli = "一个iPad";
//        }else{
//            jiangli = "什么也没有";
//        }
//        System.out.println("奖励" + jiangli);
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入第一个整数：");
        int i1 = scan.nextInt();
        System.out.print("请输入第二个整数：");
        int i2 = scan.nextInt();
        System.out.print("请输入第三个整数：");
        int i3 = scan.nextInt();

        if (i1 > i2) {
            if (i2 > i3) {
                System.out.println("" + i3 + i2 + i1);
            } else if (i1 < i3) {
                System.out.println("" + i2 + i1 + i3);
            } else {
                System.out.println("" + i2 + i3 + i1);
            }
        } else {
            if (i1 > i3) {
                System.out.println("" + i3 + i1 + i2);
            } else if (i3 > i2) {
                System.out.println("" + i1 + i2 + i3);
            } else {
                System.out.println("" + i1 + i3 + i2);
            }
        }
    }
}

