package com.atguigu.bigdata.java;

public class Java08_Static {
    public static void main(String[] args) throws Exception {

         // sleep, wait方法的区别？
        Thread t1 = new Thread();
        Thread t2 = new Thread();

        t1.start();
        t2.start();

        Thread.sleep(1000);// 1. 静态方法, 休眠的线程不是t1,是main线程
        t2.wait(); // 2. 成员方法，等待的线程是t2

        //char c = 'B' + 1;
        //System.out.println(c);


    }
}

