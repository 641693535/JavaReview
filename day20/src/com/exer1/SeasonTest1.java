package com.exer1;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO 使用自定义枚举类方法来定义枚举类
 * @Date 2021-06-07 12:58
 */
        public class SeasonTest1 {
            public static void main(String[] args) {

        Season1 s1 = Season1.SPRING;
        System.out.println(s1);


    }
}
class Season1{
    private final String seasonName;
    private final String seasonDesc;

    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public static final Season1 SPRING = new Season1("春天", "春暖花开");
    public static final Season1 SUMMER = new Season1("夏天", "夏日炎炎");
    public static final Season1 AUTUMN = new Season1("秋天", "秋高气爽");
    public static final Season1 WINTER = new Season1("冬天", "白雪皑皑");

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season1{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}