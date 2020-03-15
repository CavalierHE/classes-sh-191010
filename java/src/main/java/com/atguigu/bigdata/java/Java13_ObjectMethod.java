package com.atguigu.bigdata.java;

import java.util.LinkedList;
import java.util.List;

public class Java13_ObjectMethod {
    public static void main(String[] args) throws Exception {

        byte b  = 10;

        test(b);

    }
    public static void test( byte b ) {
        System.out.println("bbbbb");
    }
    public static void test( short s ) {
        System.out.println("sssss");
    }
    public static void test( char c ) {
        System.out.println("ccccc");
    }
    public static void test( int i ) {
        System.out.println("iiiii");
    }
}
class A {
    public int i = 10;

    public int getResult() {
        return i + 10;
    }
}
class B extends A {
    public int i = 10;

    public int getResult() {
        return i + 10;
    }
}


