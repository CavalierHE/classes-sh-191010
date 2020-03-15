package com.atguigu.bigdata.java;


public class Java33_Generic1 {

    public static void main(String[] args) {

//        test(Child33.class);
        test(User33.class);
        test(Parent33.class);
    }

//    public static void test( Class<User33> c) {
//        System.out.println(c.getName());
//    }

    // 泛型的使用上限
//    public static void test( Class<? extends User33> c) {
//        System.out.println(c.getName());
//    }

    // 泛型的使用下限
    public static void test( Class<? super User33> c) {
        System.out.println(c.getName());
    }

}

class Parent33 {

}

class User33 extends Parent33 {

}

class Child33 extends User33 {

}