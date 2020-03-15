package com.atguigu.bigdata.java;

public class Java05_StringMethod {
    public static void main(String[] args) {

        // 字符串常用方法
        System.out.println(test("hello"));

    }
    public static String test( String s ) {
        // TODO 将字符串的首写字母大写返回
        //s.charAt()
        return s.substring(0,1).toUpperCase();
    }
}
