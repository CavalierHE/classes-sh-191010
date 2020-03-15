package com.atguigu.bigdata.scala.chapter05

object Scala06_Function5_Closure {

    def main(args: Array[String]): Unit = {
        //val name = "zhangsan"
        
        // TODO 函数式编程 - 闭包
//        def test(): Unit = {
//            println(name)
//        }
//        test();
        // Scala语言使用匿名函数类实现闭包效果
        def test() = {
             val name = "zhangsan"
             def test1(): Unit = {
                 println(name)
             }
             test1 _
        }
    
        test()()
    }
}
