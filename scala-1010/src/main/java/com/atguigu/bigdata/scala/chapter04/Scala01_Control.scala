package com.atguigu.bigdata.scala.chapter04

object Scala01_Control {
    def main(args: Array[String]): Unit = {
        
        // TODO 流程控制
        // TODO if - else
//        val b = true
//        if ( b ) {
//            println("true")
//        } else {
//            println("false")
//        }
//        val age = 18
//        if ( age < 20 ) {
//            println("年轻人")
//        } else if ( age < 35 ) {
//            println("青年人")
//        } else if ( age < 45 ) {
//            println("中年人")
//        } else {
//            println("老年人")
//        }
        
        // Scala和java if语法的区别：
        // Scala中所有的表达式有返回值的
        // 可以使用变量来接收返回值
        // if表达式的返回值由满足条件的最后一行代码来决定
        // 如果if表达式没有满足条件，那么返回值为Unit
        // ？:
        // int a = flg ? 10 : 20
        val flg = true
        // String & Unit => Any
        // Int & Unit => AnyVal
        val result = if ( flg ) {
            20
//            30
//            println("hello")
//            "zhangsan"
        }
        println(result)
    }
}
