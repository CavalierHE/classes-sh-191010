package com.atguigu.bigdata.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Java12_Object {
    public static void main(String[] args) throws Exception {

        // 构造方法
        //Emp12 emp = new Emp12();
        // 多态
        //Person12 person = new Emp12();

//        List list1 = new LinkedList();
//        list1.add("a");
//        list1.get(0);
//        list1.remove(1);
//
//        ArrayList list2 = new ArrayList();

        test( new LinkedList() );

        // Open Close P 开发原则 => 开闭原则
        // Spring IoC, AOP
    }
    public static void test( List list ) {
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
    }
}
class Person12 {
    public Person12( String name ) {

    }
}
class Emp12 extends Person12{
    public Emp12() {
        // 默认调用父类的无参构造方法
        // 父类的有参构造方法应该显示的调用
        super("zhangsan");
        System.out.println("1111");
    }
}

