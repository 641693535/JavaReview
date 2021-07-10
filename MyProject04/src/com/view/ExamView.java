package com.view;

import com.domain.Item;
import com.service.ItemService;

import java.util.Scanner;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-20 15:34
 */
public class ExamView {

    ItemService itemService = new ItemService();

    char[] userDaAn = new char[itemService.TOTAL];//临时保存答案的数组

    public ExamView() {
        for (int i = 0; i < userDaAn.length; i++) {
            userDaAn[i] = ' ';
        }
    }

    /**
     * 获取键盘输入的指令
     * @return
     */
    public char getUserAction(){
        Scanner scan = new Scanner(System.in);
        String key = scan.next();

        String upKey = key.toUpperCase();
        char k = upKey.charAt(0);
        switch (k) {
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'N':
            case 'P':
            case 'F':
            case 'Y':
            case '1':
            case '2':
            case '3':
                return k;
            default:
                return '0';
        }
    }

    /**
     * 显示指定考题内容，不显示答案
     * @param no
     */
    public void displayItem(int no) {
        Item item = itemService.getItem(no);
        String tiMu = item.getTiMu();
        String[] xuanxiang = item.getXuanxiang();
        System.out.println(tiMu);
        for (String s : xuanxiang) {
            System.out.println(s);
        }
        if (userDaAn[no - 1] != ' ') {
            System.out.println("您已选择答案：" + userDaAn[no - 1]);
        }
    }

    /**
     * 默认显示第一题，判断用户输入什么，来进行下一步操作
     */
    public void testExam(){
        disInfo();//开始前的菜单
        int num = 1;//记录第几题
        displayItem(num);//显示题目
        char userAction = '1';

        while(true) {
            System.out.print("请选择正确答案(p-上一题  n-下一题):");
            userAction = getUserAction();
            switch (userAction) {
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                    userDaAn[num - 1] = userAction;
                case 'N':
                    if ((num + 1) > itemService.TOTAL) {
                        System.out.println("已经到达最后一题了哦~");
                    }else {
                        displayItem(num += 1);
                    }
                    break;
                case 'P':
                    if ((num - 1) <= 0) {
                        System.out.println("当前处于第一题~");
                    }else {
                        displayItem(num -= 1);
                    }
                    break;
                case 'F':
                    if (isExit()){
                        itemService.saveAnswer(userDaAn);
                        showResult(userDaAn);
                        return;
                    }
            }
        }

    }
    
    private void showResult(char[] userDaAn){
        int score = 0;
        System.out.println("序   号   标准答案    你的答案");
        for (int i = 0; i < itemService.TOTAL; i++) {
            Item item = itemService.getItem(i + 1);
            if (item.getDaAn() == userDaAn[i]) {
                score += 10;
            }
            System.out.print("第 " + (i + 1) + ((i < 9)? " ": "") + "题\t\t" +
                    item.getDaAn() + "\t\t\t" + userDaAn[i] + '\n');
        }
        System.out.println("您的成绩为" + score);

    }

    /**
     * 确认是否退出逻辑，N不退出，返回继续答题。Y退出，保存答案到文件并判分.
     */
    private boolean isExit(){
        while (true) {
            System.out.print("请确认是否退出(Y/N):");
            char userAction = getUserAction();
            if (userAction == 'N') {
                return false;
            } else if (userAction == 'Y') {
                return true;
            }
        }
    }

    private void disInfo(){
        System.out.println();
        System.out.println("-----------欢迎进入考试-----------");
        System.out.println();
        System.out.println("       使用以下按键进行考试：");
        System.out.println();
        System.out.println("        A-B：选择指定答案");
        System.out.println("        P  ：显示上一题");
        System.out.println("        N  ：显示下一题");
        System.out.println("        F  ：结束考试");
        System.out.println();

        while (true) {
            System.out.print("        请按N键进入考试...");
            char userAction = getUserAction();
            if (userAction == 'N') {
                break;
            }
        }
    }
    /**
     * 显示主页面信息
     */
    private void displayMainMenu() {
        System.out.println();
        System.out.println();
        System.out.println("-------欢迎使用在线考试系统-------");
        System.out.println();
        System.out.println("       1 进入考试");
        System.out.println("       2 查看成绩");
        System.out.println("       3 系统退出");
        System.out.println();
        System.out.print("       请选择...");
    }

    public void enterMainMenu() {
        while (true) {
            displayMainMenu();
            char userAction = getUserAction();
            switch (userAction) {
                case '1':
                    testExam();
                    break;
                case '2':
                    char[] chars = itemService.readAnswer();
                    showResult(chars);
                    break;
                case '3':
                    if(isExit()){
                        return;
                    }
            }
        }
    }
}
