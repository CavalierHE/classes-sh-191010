package com.atguigu.bigdata.scala.chapter04

object Scala02_Control1 {
    def main(args: Array[String]): Unit = {
        
        // TODO 流程控制
        // TODO if - else

        val flg = true

        // Int & Int => Int
        // Int & String => Any
        // Null & String => String
//        val result = if ( flg ) {
//            null
//        } else {
//            "zhangsan"
//        }
        //int result = flg ? 10 : 20
        // Scala中没有三元运算符
        val result = if ( flg ) 10 else 20
        println(result)
    }
}
