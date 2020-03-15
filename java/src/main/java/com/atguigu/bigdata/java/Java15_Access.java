package com.atguigu.bigdata.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Java15_Access {
    public static void main(String[] args) throws Exception {

        // TODO 访问权限
        // private : 私有的 （同类）
        // (default) : 包权限 （同类，同包）
        // protected ： 受保护权限（同类，同包，子类）
        // public : 公共的

        // 访问权限：会员和系统之间的关系
        // 所谓的访问权限其实就是方法的调用者和方法提供者之间的关系
        // 方法提供者：com.atguigu.bigdata.java.User15
        // 方法调用者：com.atguigu.bigdata.java.Java15_Access

        // java.lang.Object 和 com.atguigu.bigdata.java.Java15_Access
        // 没有父子关系

        // Object
        //Object obj = null;
        User15 user = new User15();
        user.clone();

        // 将zhangsan赋值给user对象中的name属性
        // 点的作用不是调用，是从属关系。
        //user.name = "zhangsan";

    }
}
class User15 {
    public String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}



