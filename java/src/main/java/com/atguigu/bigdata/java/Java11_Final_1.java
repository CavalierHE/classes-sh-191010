package com.atguigu.bigdata.java;

import java.lang.reflect.Field;

public class Java11_Final_1 {
    public static void main(String[] args) throws Exception {

        // final finalize finally
        System.out.println(test());


    }
    public static int test() {
        int i = 0;

        try {
            //return i++;
            // 1) _tmp = i++ = 0; i = 1;
            // 2) _rtnVal = _tmp = 0;
            // 3) finally
            // 4) return _rtnVal
            return 1;
            // _rtnVal = 1
        } finally {
            return 2;
            // _rtnVal = 2

            //return _rtnVal
            //++i;
            //return ++i;
            // 1) _tmp = ++i = 2; i = 2;
            // 2) _rtnVal = _tmp = 2;
            // 3) return _rtnVal
        }
    }

    @Override
    // 一次申辩的机会
    protected void finalize() throws Throwable {
        // 析构方法
        super.finalize();
    }
}

