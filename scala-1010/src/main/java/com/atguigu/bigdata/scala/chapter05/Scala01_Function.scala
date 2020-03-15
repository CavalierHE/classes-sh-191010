package com.atguigu.bigdata.scala.chapter05

object Scala01_Function {
    // 方法，可以重载
    def test1(): Unit = {
    
    }
    def test1(s:String): Unit = {
    
    }
    def main(args: Array[String]): Unit = {
        // TODO 函数式编程
        // 面向对象编程 & 函数式编程
        // 面向对象：解决问题是将问题进行分解，形成一个一个对象，通过组合对象
        //           或调用对象的功能来解决问题
        // 函数式编程：解决问题是将问题分解一个一个功能，对功能进行封装（函数），
        //           通过调用不同封装的功能来解决问题
        // Scala 函数的声明 ：
        //     def 函数名称（函数的参数列表）: 函数的返回值类型 = { 函数体 }
        //     def 方法名称（方法的参数列表）：方法的返回值类型 = { 方法体 }
        
        // 函数和方法的区别
        // 1. 方法其实就是函数，只不过声明在特殊的位置
        //    声明在类中的函数称之为方法，声明在其他语法结构中函数称之为函数
        // 函数可以声明在任意的语法结构中
        def test(): Unit = {
            def test2(): Unit = {

            }
        }

        println(test)

        // 2. 方法有重载和重写的，函数是没有重载和重写
        def test2(): Unit = {
        
        }

//      def test2(s:String): Unit = {
//
//      }
    }
}
