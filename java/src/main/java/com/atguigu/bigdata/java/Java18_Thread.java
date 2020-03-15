package com.atguigu.bigdata.java;

import java.util.List;

public class Java18_Thread {
    public static void main(String[] args) throws Exception {

        // TODO 线程安全问题
        // 所谓的线程安全问题，其实是多线程并发时，对共享内存中共享对象的属性
        // 进行修改时，所产生的数据冲突问题。
        // 栈内存是每个线程独享的内存空间
        // 解决方案：
        // 1.多线程串行（同步）：不推荐使用，性能低
        // 2.对独享内存中的数据做操作: 不推荐使用
        //    共享内存：堆，方法区
        //    独享内存：栈
        //    栈上分配，逃逸分析
        // 3.线程不对共享对象做操作：多例
        // 4.方法调用不会出现线程安全问题
        // 5.访问属性而不修改属性也不会出现线程安全问题。
        User18 user = new User18();
        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        user.name = "zhangsan";
                        try {
                            Thread.sleep(1000);
                        } catch ( Exception e ) {
                            e.printStackTrace();
                        }
                        System.out.println(user.name);
                    }
                }
        );
        Thread t2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        user.name = "lisi";
                        try {
                            Thread.sleep(1000);
                        } catch ( Exception e ) {
                            e.printStackTrace();
                        }
                        System.out.println(user.name);
                    }
                }
        );

        t1.start();
        t2.start();

        System.out.println("main方法执行完毕");

        // 1. main方法执行完毕
        //    zhangsan
        //    lisi

        // 2. main方法执行完毕
        //    lisi
        //    zhangsan

        // 3. lisi
        //    main方法执行完毕
        //    zhangsan

        // 4. main方法执行完毕
        //    zhangsan(lisi)
        //    zhangsan(lisi)
    }

}
class User18 {
    public String name;
}


