package com.atguigu.bigdata.java;

public class Java26_StringUtil {
    public static void main(String[] args) throws Exception {
        System.out.println(isEmpty(null));

    }
    public static boolean isEmpty( String s ) {
       return s == null || s.equals(""); // 短路或
       // return s == null | s.equals(""); // 逻辑或
    }

}



