package com.atguigu.bigdata.java;

import java.util.List;

public class Java17_Exception1 {
    public static void main(String[] args) throws Exception {

        // TODO 空指针异常
        //User17 user = new User17();

        // Integer.intValue
        // 拆箱：包装类型 => 基本类型
        // 包装类型为null，进行拆箱时就会出现空指针异常
        //test(user.age);

        // 装箱：基本类型 => 包装类型
        // Integer.valueOf
//        Integer i1 = null;
//        Integer i2 = 127;
//        System.out.println(i1 == i2);
        List list = null;//service.getUserList();

        // 源码 & 字节码
        for ( Object obj : list ) {
            System.out.println(obj);
        }
    }
    public static void test( int age ) {
        System.out.println("age = " + age);
    }
}

class User17 {
    public  Integer age;
}


