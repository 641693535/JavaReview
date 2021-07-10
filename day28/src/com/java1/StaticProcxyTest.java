package com.java1;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO 静态代理举例
 * @Date 2021-06-19 23:22
 */
public class StaticProcxyTest {

    public static void main(String[] args) {
        JingJiRen jingJiRen = new JingJiRen(new YiRen());
        jingJiRen.perform();
    }

}

interface YanYiQuan{
    void perform();
}

class JingJiRen implements YanYiQuan{

    private YiRen yiren;

    public JingJiRen(YiRen yiren) {
        this.yiren = yiren;
    }

    public void perform() {
        System.out.println("经纪人商讨事宜");
        System.out.println("经纪人商讨报酬");
        yiren.perform();
        System.out.println("经纪人收尾工作");
    }

}

class YiRen implements YanYiQuan{

    public void perform(){
        System.out.println("艺人开始表演");
    }

}
