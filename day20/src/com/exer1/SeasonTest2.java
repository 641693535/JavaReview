package com.exer1;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO 使用enum关键字来定义枚举类
 * @Date 2021-06-07 13:02
 */
public class SeasonTest2 {
    public static void main(String[] args) {
        Season2 s1 = Season2.SPRING;
        System.out.println(s1);

        System.out.println(Season2.class.getSuperclass());

        Season2[] values = Season2.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }

        s1.show();
    }
}
interface Info{
    public abstract void show();
}

enum Season2 implements Info{
    SPRING("春天", "春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("夏天", "夏日炎炎"){
        @Override
        public void show() {
            System.out.println("夏日炎炎，有你超甜!");
        }
    },
    AUTUMN("秋天", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天", "白雪皑皑"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

    private final String seasonName;
    private final String seasonDesc;

    private Season2(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

}