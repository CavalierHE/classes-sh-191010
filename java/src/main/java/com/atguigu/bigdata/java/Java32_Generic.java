package com.atguigu.bigdata.java;

import java.util.ArrayList;
import java.util.List;

public class Java32_Generic {

    public static void main(String[] args) {

        // 泛型的不可变
        //List<User32> list = new ArrayList<User32>();
        //list.add(new User32());
        //list.add(new Child32());

        List list = new ArrayList();
        list.add(new Emp32());

        // 泛型的使用范围
        // 泛型声明后，只能对后续的操作进行类型的约束
        List<User32> list1 = list;
        // 泛型是在使用类型约束的场合下起作用
        System.out.println(list1.toString());

        for(User32 user : list1) {
            System.out.println(user);
        }
    }

}

class Parent32 {

}

class User32 extends Parent32 {

}

class Child32 extends User32 {

}

class Emp32 {

}