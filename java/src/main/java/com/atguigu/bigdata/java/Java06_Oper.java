package com.atguigu.bigdata.java;

public class Java06_Oper {
    public static void main(String[] args) {

        // ++ --
        //int i = 0;
        //int j = i++;
        //i = i++; // 1） _tmp = i++; => _tmp = 0; i = 1 2) i = _tmp = 0
        //System.out.println("i = " + i + ",j = " + j);
        //System.out.println("i = " + i);
        // 三种讲解方式
        // 1. 先赋值，再运算（+1）
        // 2. 等号：将等号右边的计算结果给左边(临时变量)
            //    1 + 1 + 1 = 3
            // 123123 + 234234 + 2342  = ？
            // 1 + 1 = 2
            // 2 + 1 = 3
            // 计算机会保存临时计算变量
        // 3. 字节码

        // 1 - 1111111 = 翻译 => 8位中负数的最大值 => -1
        // 10000000 => 8位中负数的最小值 => -128
        // -127 => -128 + 1 => 10000000 + 1 => 10000001
        //
        // 高位0 => 正数，低位
        // 高位1 => 负数，低位

        // 5 & 4 = ?
        //    0000 0101
        // &
        //    0000 0100
        //---------------
        //    0000 0100 => 4

        // 1000 0000
        // 32
        // 0000 0000 0000 0000 0000 0000 1000 0000
        //                               1000 0000

        // 1 + 000 0000 = 8位中负数的最小值 = -128
        int i = 128;
        byte b = (byte)i;
        System.out.println(b);

    }

}
