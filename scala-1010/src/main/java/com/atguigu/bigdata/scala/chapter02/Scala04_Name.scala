package com.atguigu.bigdata.scala.chapter02

object Scala04_Name {
    def main(args: Array[String]): Unit = {
        
        // TODO 标识符
        
        // 以字母或者下划线开头，后接字母、数字、下划线
        val name = "zhangsan"
        val user_name = "lisi"
        val name1 = "wangwu"
        val user$name = "zhaoliu"
        
        //val 1name = "xxx"  (X)
        val $name = "zhangsan"
        val _name = "lisi"
        
        val $ = "zhangsan"
        val _ = "zhangsan"
        
        // 使用独立的下划线可以作为标识符，但是使用上会有限制
        //println(_);
        
        // 中文标识符
        //val 元宵节 = "元宵节"
        //println(元宵节)
        
    }
}
