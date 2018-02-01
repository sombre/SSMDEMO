package com.ssm.test;


//实现接口的目标对象
public class UserDao implements IUserDao,ICustomer {
    public void say() {
        System.out.println("say");
    }

    public void doIt() {
        System.out.println("do");
    }
}
