package com.atguigu.bigdata.java;

import static com.atguigu.bigdata.java.StringUtil.*;

public class Java04_String {
    public static void main(String[] args) {

       // 字符串
        // 1. 不可变字符串，2. 可变字符串
        // TODO 不可变字符串
        // String类提供的任何方法不能改变当前字符串，都会产生新的字符串
//        String s = " a b "; // 5
//        s = s.trim(); // 3
//        System.out.println("!"+s+"!");
        // 1. !a b!
        // 2. !ab! error
        // 3. ! a b !
        // TODO 可变字符串
        // StringBuilder, StringBuffer
        // ArrayList
        //new StringBuilder();
        //new StringBuffer();

//        String s1 = new String("abc");
//        String s2 = new String("abc");
//        System.out.println(s1 == s2);

        // 静态导入，静态属性和静态方法类名可以省略
        System.out.println(isEmpty("abc"));
        System.out.println(A);

    }
}
