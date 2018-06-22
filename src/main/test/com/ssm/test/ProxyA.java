package com.ssm.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 创建动态代理对象
 * 动态代理不需要实现接口,但是需要指定接口类型
 */
public class ProxyA implements InvocationHandler{

    //维护一个目标对象
    private Object target;
    public ProxyA(Object target){
        this.target=target;
    }




    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("在做say之前");
        Object result = method.invoke(this.target,args);
        System.out.println("在做say之后");
        return result;
    }



    public static void main(String[] args) {
        // 目标对象
        IUserDao target = new UserDao();
        // 【原始的类型 class cn.itcast.b_dynamic.UserDao】
        System.out.println(target.getClass());
        // 给目标对象，创建代理对象
        IUserDao proxy = (IUserDao) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),new ProxyA(target));
        // class $Proxy0   内存中动态生成的代理对象
        System.out.println(proxy.getClass());
        proxy.say();
        ICustomer test = (ICustomer) proxy;

        test.doIt();

        IUserDao gew= (IUserDao) proxy;
        gew.fly();

        ICustomer tmp = (ICustomer) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new ProxyG(target));
        // 执行方法   【代理对象】

//        proxy.say();
//        tmp.doIt();


    }


}