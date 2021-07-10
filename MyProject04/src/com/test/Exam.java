package com.test;

import com.view.ExamView;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-06-20 15:34
 */
public class Exam {

    public static void main(String[] args) {

//        ItemService itemService = new ItemService();
        ExamView examView = new ExamView();
//
//        List<String> strings = itemService.readTextFile("MyProject04\\Items.txt");
//        for (String s : strings) {
//            System.out.println(s);
//        }
//        Item item = itemService.getItem(1);
//        System.out.println(item.toString());

//        itemService.saveAnswer(new char[]{'A','B'});

//        while (true) {
////            char userAction = examView.getUserAction();
////            System.out.println(userAction);
////            if (userAction == '0') {
////                break;
////            }
////        }
//        examView.displayItem(1);
//        examView.testExam();

        examView.enterMainMenu();
    }

}
