package com.atguigu.bigdata.java;

import java.util.ArrayList;
import java.util.List;

public class Java31_Override {
    public static void main(String[] args) throws Exception {
        Parent31 user = new User31();
        System.out.println(user.age);

        //  动态绑定机制(成员方法和对象的实际内存进行绑定)和对象的成员方法有关系，和属性无关
        user.test();

//        List list = new ArrayList();
//        list.add()
    }
}

class Parent31 {
    public int age = 10;
    public void test() {
        System.out.println("parent test...");
    }
}

class User31 extends Parent31 {
    public int age = 20;
    @Override
    public void test() {
        System.out.println("user test...");
    }
}