package com.atguigu.bigdata.java;

public class Java19_Thread1 {
    public static void main(String[] args) throws Exception {

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        test();
                    }
                }
        ).start();
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        test();
                    }
                }
        ).start();
    }
    public static void test() {
        // 可变字符串
        // StringBuilder, StringBuffer
        StringBuilder s1 = new StringBuilder();
        String s = "";
        for ( int i = 0; i < 1000000L; i++ ) {
            //s = s + i;
            s1.append(i);
        }
        System.out.println("s = " + s);
    }
}


