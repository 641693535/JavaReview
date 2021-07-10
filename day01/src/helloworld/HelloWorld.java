package helloworld;

import org.junit.Test;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2020-11-22 21:36
 */
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("HelloWorld!");
    }
    @Test
    public void testMaxNum(){
        int n1 = 10,n2 = 6,n3 = 28;
        int maxNum = (n1 > n2)? ((n1 > n3)? n1 : n3) : ((n2 > n3)? n2 : n3);
        System.out.println(maxNum);

        if(n1 > n2 && n1 > n3){
            maxNum = n1;
        }else if(n2 > n1 && n2 > n3){
            maxNum = n2;
        }else if(n3 > n1 && n3 > n2){
            maxNum = n3;
        }
        System.out.println(maxNum);
    }

    @Test
    public void testHuan(){
        int n1 = 128,n2 = 256;
        System.out.println("n1 = " + n1);
        System.out.println("n2 = " + n2);
        int n3 = n1 ^ n2;
        n1 = n1 ^ n3;
        n2 = n2 ^ n3;
        System.out.println("n1 = " + n1);
        System.out.println("n2 = " + n2);
    }
    @Test
    public void testHuanString(){
        String s1 = "南京",s2 = "北京";
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        String temp  = s1;
        s1 = s2;
        s2 = temp;
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }

    @Test
    public void testCheng(){
        //用高效的方法计算2*8
        //1
        System.out.println(2 << 3);
        //2
        System.out.println(2 * 8);
        //3
        System.out.println(8 << 1);
    }
}
