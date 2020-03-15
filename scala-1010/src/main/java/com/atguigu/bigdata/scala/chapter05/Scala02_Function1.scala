package com.atguigu.bigdata.scala.chapter05

object Scala02_Function1 {

    def main(args: Array[String]): Unit = {
        
        // TODO 函数式编程
        
        // 函数的声明
        def test(): Unit = {
            println("test...")
        }
        
        // 函数的调用 ： 函数名（参数）
        // 函数关心三件事情：
        // 1. 函数名
        // 2. 输入参数（In）
        // 3. 返回结果(Out)
        test()
        test
    }
}
