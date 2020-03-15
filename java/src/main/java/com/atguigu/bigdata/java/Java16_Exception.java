package com.atguigu.bigdata.java;

public class Java16_Exception {
    public static void main(String[] args) throws Exception {

        // TODO 异常：所有的异常其实都是在运行时产生的
        // Java 健壮性
        // try catch
        // Exception
        // 编译时异常（编译时，语法异常）
        // 提示性异常 FileNotFoundException,IOException, SQLException

        // 运行时异常（运行时产生的异常）
        // 可以通过编程手段解决：BUG， 空指针，索引越界， 类型转换

        // 空指针异常：null
        // （X）: 一个对象为空（null），访问这个对象会发生空指针异常
        // （X）: 一个对象为空（null），访问这个对象的属性或方法会发生空指针异常
        // （OK）: 一个对象为空（null），访问这个对象的成员属性或成员方法会发生空指针异常
        User16 user = null;
        user.name = "lisi";
        System.out.println(user);
    }
}
class User16 {
    public static String name = "zhangsan";
}


