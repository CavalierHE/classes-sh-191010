package com.atguigu.bigdata.scala.chapter01


object Scala01_HelloWorld {
    
    def main(args: Array[String]): Unit = {
        // Scala语言基于Java语言，所以很多的语法结构非常类似的
        // 很多的Java代码可以在Scala程序中使用
        // Java
        System.out.println("Hello World");
        
        // Scala
        // 1. 可以简化Java代码
        // 2. java声明类使用class关键字
        //    public class User {} => User.class
        //    scala会对使用object声明的类编译产生2个类文件
        //       类名.class
        //       类名$.class
        // 3. java程序的入口方法main
        //    public static void main(String[] args)
        //    scala : def main(args: Array[String]): Unit
        //    java  : public void main(String[] args)
        
        // main(入口) => 类名$.MODULE$.main => println("Hello World")
        
        // TODO Scala和Java的区别
        // 1. Java不是一个完全面向对象的语言
        // 2. Scala是完全面向对象的语言：万物皆对象
        //    Scala在编译object声明的类的时候，会生成一个特殊的类而且创建这个类的单例对象。
        //    Scala使用这个单例对象模拟java中的静态语法，因为Scala中没有静态语法
        //    Scala将这个类所产生的单例对象称之为伴生对象
        println("Hello World")
    }
}
