package com.atguigu.bigdata.scala.chapter05

import scala.util.control.Breaks._

object Scala11_Function10_Abstract {

    def main(args: Array[String]): Unit = {
        // TODO 函数式编程 - 控制抽象
        
        // 将一段逻辑代码作为参数传递给函数
        // op: => Unit    《=》  op: () => Unit
        // 参数名：op
        // 参数类型：=> Unit，省略了()
        breakable (
            for ( i <- 1 to 5 ) {
                if ( i == 3 ) {
                    break
                }
                println("i = " + i)
            }
        )
        println("main方法。。。。")
    }
}
