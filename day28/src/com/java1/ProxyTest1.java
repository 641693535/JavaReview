package com.java1;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO 动态代理
 * @Date 2021-06-20 12:17
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理接口
 */
interface Proxy{
    String getBeleif();

    void make(String type);
}

/**
 * 被代理类
 */
class LiNing implements Proxy{


    @Override
    public String getBeleif() {
        return "一切皆有可能!";
    }

    @Override
    public void make(String type) {

        System.out.println("我开始制作" + type);

    }
}

/**
 * 代理类
 */
class makeProxy{
    public static Object makePro(Object obj){

        MyInvocation myInvocation = new MyInvocation();

        myInvocation.bind(obj);

        Object o = java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), myInvocation);
        return o;

    }
}

class MyInvocation implements InvocationHandler {

    Object obj;

    public void bind(Object object) {
        this.obj = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object invoke = method.invoke(obj, args);

        return invoke;
    }
}

public class ProxyTest1 {

    public static void main(String[] args) {

        SuperMan superMan = new SuperMan();

        Human o = (Human) makeProxy.makePro(superMan);

        o.eat("烩面");


        LiNing liNing = new LiNing();
        Proxy li = (Proxy) makeProxy.makePro(liNing);

        String beleif = li.getBeleif();
        System.out.println(beleif);

        li.make("T恤");

    }


}
