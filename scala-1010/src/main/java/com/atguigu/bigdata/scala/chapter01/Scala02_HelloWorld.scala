package com.atguigu.bigdata.scala.chapter01

object Scala02_HelloWorld {
    
    def main(args: Array[String]): Unit = {
        
        // TODO Scala和Java的区别
        //    scala : def main(args: Array[String]): Unit
        //    java  : public void main(String[] args)
        
        // 1. Scala语言默认的方法访问权限就是公共的。所以Scala没有public关键字
        // 2. Scala语言采用def关键字声明方法。
        // 3. scala参数列表 ：args: Array[String]
        //    java的参数列表：String[] args
        //    语言侧重点
        //    java : 强类型语言
        //        String[] args
        //    scala : 任务标识符名称更加的重要
        //        args : Array[String]
        // 4. java  : void main()
        //    scala : main() : Unit
        //    Scala语法中Unit和java语法中void的含义是一致。无返回值的意思
        //    Java不是完全面向对象的语言，所以其中包含了不是面向对象的语法
        //    void关键字就不是面向对象的语法，所以Scala语言采用了面向对象的语法来代替
        //    Unit
        
        println("Hello World")
    }
}
