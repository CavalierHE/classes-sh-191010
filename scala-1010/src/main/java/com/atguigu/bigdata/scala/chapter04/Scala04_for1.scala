package com.atguigu.bigdata.scala.chapter04

object Scala04_for1 {
    def main(args: Array[String]): Unit = {
        
        // TODO for循环
        // 循环守卫
//        for ( i <- 1 to 5  if  (i%2 == 0) ) {
//            println("i = " + i)
//        }
        
        // 循环步长
//        for( i <- 1 to 5 by 2 ) {
//            println("i = " + i)
//        }
        
        // 嵌套循环
        // for () {
        //    println()
        //    for() {
        //        println()
        //    }
        // }
//        for(i <- 1 to 3; j <- 1 to 3) {
//            println(" i =" + i + " j = " + j)
//        }
        
        // 引入变量
        //for(i <- 1 to 3; j = 4 - i) {
//        for {
//            i <- 1 to 3
//            j = 4 - i
//        } {
//            println("i=" + i + " j=" + j)
//        }
        
        // 循环返回值
        // for循环的返回结果默认就是Unit
//        val result = for (i <- 1 to 5) {
//            i
//        }
//        println("result = " + result)
        
        // 如果想要将循环的结果进行处理后返回，需要特殊操作
//        val res = for(i <- 1 to 10) yield "i = " + i
//        println(res)
        
        // 倒序打印
        for(i <- 1 to 10 reverse){
            println(i)
        }
    }
}
