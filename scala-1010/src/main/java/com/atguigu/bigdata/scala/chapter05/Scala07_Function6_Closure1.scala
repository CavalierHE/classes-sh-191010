package com.atguigu.bigdata.scala.chapter05

object Scala07_Function6_Closure1 {

    def main(args: Array[String]): Unit = {
        // TODO 函数式编程 - 闭包
        // Scala使用匿名函数类进行语法中闭包的处理
        
        // TODO 1. 函数调用main方法中的变量，不会出现闭包效果
//        val name = "zhangsan"
//        def test(): Unit = {
//            // 函数访问函数之外的变量
//            println( name )
//        }
        //test()
        
        // TODO 2. 嵌套函数调用main方法中的变量，出现闭包效果
        //         如果不访问变量，那么只要是嵌套函数的执行就会出现闭包效果
//        val name = "zhangsan"
//        def test() = {
//            def test1(): Unit = {
//                // 嵌套函数访问main方法中的变量
//                println(name)
//            }
//
//            test1 _
//        }
    
        //test()
        
        // TODO 3. 将函数赋值给变量进行调用时，也会产生闭包效果
        val name = "lisi"
        def test(): Unit = {
            println(name)
        }
        val t = test _
        t()
        
        // TODO 4. 匿名函数都有闭包
        //val f = () => {println("closure")}
        //f()
        def f1( f:(Int)=>Int ): Unit = {
            println(f(20))
        }
        f1( _ * 20 )
    }
}
