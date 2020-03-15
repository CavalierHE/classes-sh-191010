package com.atguigu.bigdata.java;

public class Java30_Interface {
    public static void main(String[] args) throws Exception {

        //A30 a = new C30();  //  多态的传递
        A30 a = new B30();
        B30 b = new C30();

        System.out.println(a);
        System.out.println(b);

        //  子类和父类的接口没有任何的关系
        //  Scala中没有interface
        System.out.println(C30.class.getInterfaces().length);
    }
}

interface A30 {

}

class B30 implements A30 {

}

class C30 extends B30 {

}



