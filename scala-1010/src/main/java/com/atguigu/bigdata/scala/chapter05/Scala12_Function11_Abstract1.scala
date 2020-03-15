package com.atguigu.bigdata.scala.chapter05

import scala.util.control.Breaks._

object Scala12_Function11_Abstract1 {

    def main(args: Array[String]): Unit = {
        // TODO 函数式编程 - 控制抽象
//        while (true) {
//            println("zhangsan")
//        }
    
        // 可以自己增加语法
        myWhile( true ) {
            println("zhangsan")
        }
    }

    //myWhile(flg:Boolean)(op: => Unit)为函数柯里化，
    // (op: => Unit)为控制抽象的代码逻辑：{println("zhangsan")}
    def myWhile(flg:Boolean)(op: => Unit): Unit = {
        if (flg) {
            op
            //尾递归
            myWhile(flg)(op)
        }
    }
}
