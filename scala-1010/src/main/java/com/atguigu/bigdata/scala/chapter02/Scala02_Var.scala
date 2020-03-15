package com.atguigu.bigdata.scala.chapter02

object Scala02_Var {
    def main(args: Array[String]): Unit = {
        
        // TODO 变量 & 常量
        // java : public String name = "zhangsan";
        //        访问权限  类型  变量名称 = 变量值;
        
        // Scala : 访问权限 var 变量名称:类型 = 变量值
        // Scala中变量和方法声明规则一致的
        // Scala中使用两个关键字来声明变量 var | val
        //    var : 变量，值可以发生改变
        //    val : 不可变变量，值一旦初始化后无法发生改变
        //    开发程序中，为了避免程序出现问题，不推荐频繁更改变量的值
        //    所以使用val关键字更多一些。
        var name : String = "zhangsan"
        val email : String = "zhangsan@xxx.com"
    
        name = "lisi"
        //email = "lisi@163.com"
        
        println(name)
        println(email)
    }
}
