package com.atguigu.bigdata.scala.chapter01

object Scala03_HelloWorld {
    
    def main(args: Array[String]): Unit = {
        //println("Hello World")
        // TODO Scala和Java的区别
        // 1. Scala语法中的访问方式是一致的。
        //  def 方法名():返回值类型 = {方法体}
        
        //   int a = 10;
        //   public void main() {  方法体 }
        
        // 2. Scala中方法体中可以直接使用Java代码，也可以使用Scala代码
    
        test()
    }

    // 声明一个叫做test的方法，并且没有返回值，其中的逻辑就是打印Hello字符串
    def test():Unit = {
        println("Hello World")
    }
}
