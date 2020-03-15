package com.atguigu.bigdata.scala.chapter03

object Scala01_Operator {
    def main(args: Array[String]): Unit = {
        
        // TODO 运算符
        // ==
        val i = 10
        val j = 10
        println( i == j )
        
        val s1 = new String("abc")
        val s2 = new String("abc")
        // Scala语言中字符串的 == 运算符表示比较字符串的内容，类似于java中的 equals
        println(s1 == s2)
        // Scala语言中字符串的 eq 运算符表示比较字符串的内存地址，类似于java中 ==
        println(s1 eq s2)
    }
}
