package com.atguigu.bigdata.java;

import java.lang.reflect.Field;

public class Java10_Final {
    public static void main(String[] args) throws Exception {

        // Final
        // 不可变字符串 String
        // private final char[] value = new char[5];
        // final修饰的变量的值一旦初始化后无法发生改变，内容是否可以改变？
        // 类树 => 类体系树
        // 字符串String类没有提供任何改变字符串内容的方法
        // 所有改变内容的方法全部都会产生新的字符串，所以String类才是不可变字符串
        String s = "abc";
        System.out.println(s);

        // 可以使用反射的方式改变字符串的内容
        Class<? extends String> aClass = s.getClass();

        // 根据名称获取类的属性对象
        Field f = aClass.getDeclaredField("value");
        f.setAccessible(true);
        // 获取类属性的值
        char[] cs = (char[])f.get(s);
        cs[1] = 'd';

        System.out.println(s);


    }
}

