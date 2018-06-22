package com.ssm.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LittleTest {




    public static void change(String s1,String s2){
        s1 = s2;
        s2 = s1+s2;
    }
    public static void change(H h1,H h2){
        H h3 = h1;
//        h1.ite=3;
        h1 = h2;
        h2 =h3;
    }
    public  static void main(String args[]){

        String s1 = "hello";
        String s2 = "world";
        System.out.println(s1+"---"+s2);
        change(s1,s2);
        System.out.println(s1+"---"+s2);

        char b[] = {'d','b'};

        H h1 = new H(1);
        H h2 = new H(2);
        change(h1,h2);
        System.out.println(h1.ite+"-----"+h2.ite);
    }
}

