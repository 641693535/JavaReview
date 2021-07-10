package com.java1;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO 动态代理举例
 * @Date 2021-06-19 23:38
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类的接口
 */
interface Human{
    String getBelief();

    void eat(String food);
}

/**
 * 被代理类
 */
class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "I belief i can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

/**
 * 代理类的创建类
 */
class MakeProxy{
    //创建一个创建代理类的方法
    public static Object getProxy(Object obj){
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();

        myInvocationHandler.bind(obj);
        //调用代理方法中的创建方法
        Object object = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), myInvocationHandler);

        return object;

    }
}
class MyInvocationHandler implements InvocationHandler {

    Object obj;
    public void bind(Object obj){
        this.obj = obj;
    }

    /*
    proxy为MakeProxy创建的代理类的对象，Method为接口中的实现方法，args为形参。
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(obj, args);
        return invoke;
    }
}

public class ProxyTest {

    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human proxy = (Human) MakeProxy.getProxy(superMan);
        String belief = proxy.getBelief();
        System.out.println(belief);
        proxy.eat("香肠");

    }

}

