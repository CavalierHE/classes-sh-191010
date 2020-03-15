package com.atguigu.bigdata.scala.chapter05

object Scala08_Function7_Curry {

    def main(args: Array[String]): Unit = {
        // TODO 函数式编程

        def test(a:Int) = {
             val ar = a + 10
             def test1( b:Int ) = {
                 val br = b + 20
                 def test2(c : Int) = {
                     val cr = c + 30
                     ar + br + cr
                 }
                 test2 _
             }
             test1 _
         }
        // 函数柯里化 ： 将复杂的逻辑简单化
        //               将一个大的参数列表分解成多个的只有一个参数的参数列表
      println(test(10)(20)(30))
        // 函数柯里化一定要有闭包
        def f(a:Int)(b:Int)(c:Int): Int = {
            a + b + c
        }
        println( f(1)(2)(3) )
    }
}
