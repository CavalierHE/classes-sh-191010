package com.atguigu.bigdata.scala.chapter03

object Scala03_Operator2 {
    def main(args: Array[String]): Unit = {
        
        // TODO 阶乘
        // 5 ！ = 5 * 4 * 3 * 2 * 1
        // 对象 方法
        //println(new Num(5) !)
        println( 5! )
    }
    // 声明类
    implicit class Num( num:Int ) {
        // 阶乘
       def !(): Int = {
           if ( num <= 1 ) {
               1
           } else {
//               num * ( new Num( num-1 ) !)
               num * ( ( num-1 ) ! )
           }
       }
    }
}
