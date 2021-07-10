import jdk.jshell.execution.Util;

import java.util.Scanner;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-05-21 23:37
 */
public class FamilyAccount {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean loopFlag = true;
        String details = "收支\t账户金额\t收支金额\t\t说明\n";
        int balance = 10000;
        while (loopFlag) {
            System.out.println("-----------------家庭收支记账软件-----------------\n");
            System.out.println("\t\t\t\t\t1 收支明细");
            System.out.println("\t\t\t\t\t2 登记收入");
            System.out.println("\t\t\t\t\t3 登记支出");
            System.out.println("\t\t\t\t\t4 退\t出\n");
            System.out.print("\t\t\t\t\t请选择(1-4):");
            char userNum = Utility.readMenuSelection();
            switch (userNum) {
                case '1':
                    System.out.println("-----------------当前收支明细记录-----------------");
                    System.out.println(details);
                    System.out.println("-------------------------------------------------");
                    break;
                case '2':
                    System.out.print("本次收入金额：");
                    int incomeBalance = Utility.readNumber();
                    System.out.print("本次收入说明：");
                    String incomeExplain = Utility.readString();
                    //处理账户总余额
                    balance += incomeBalance;
                    //处理账户明细信息
                    details += "收入\t" + balance + "\t" + incomeBalance + "\t\t\t" + incomeExplain + "\n";
                    System.out.println("--------------------登记完成----------------------");
                    break;
                case '3':
                    System.out.print("本次支出金额：");
                    int payBalance = Utility.readNumber();
                    System.out.print("本次支出说明：");
                    String payExplain = Utility.readString();
                    if (payBalance > balance) {
                        System.out.println("超出支出金额，请重试！");
                    }else {
                        //处理账户总余额
                        balance -= payBalance;
                        details += "支出\t" + balance + "\t" + payBalance + "\t\t\t" + payExplain + "\n";
                        System.out.println("--------------------登记完成----------------------");
                    }
                    break;
                case '4':
                    System.out.print("确认是否退出(Y/N)：");
                    char isExit = Utility.readConfirmSelection();
                    if (isExit == 'Y') {
                        loopFlag = false;
                        System.out.println("退出成功~！");
                    }
            }
        }
    }
}
