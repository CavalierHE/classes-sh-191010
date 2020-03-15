package com.atguigu.bigdata.java;

public class Java27_Rec {
    public static void main(String[] args) throws Exception {
        // TODO 递归 ： 阶乘！
        // 5！ = 5 * 4! = 5 * 4 * 3! = 5 * 4 * 3 * 2！ = 5 * 4 * 3 * 2 * 1
        System.out.println(test(5));
    }
    public static int test( int num ) {
        if ( num <= 1 ) {
            return 1;
        } else {
            return num * test(num-1);
        }
    }


}



