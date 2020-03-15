package com.atguigu.bigdata.java;

import java.util.Random;

public class Java35_Random {

    public static void main(String[] args) {

        // 随机数不随机
        Random r1 = new Random(10);

        for (int i = 0; i < 5; i++) {
            System.out.println(r1.nextInt(10));
        }

        System.out.println("***************************");
        Random r2 = new Random(10);

        for (int i = 0; i < 5; i++) {
            System.out.println(r2.nextInt(10));
        }
    }

}