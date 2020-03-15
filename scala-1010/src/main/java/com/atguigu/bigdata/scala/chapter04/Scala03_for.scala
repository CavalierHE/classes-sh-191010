package com.atguigu.bigdata.scala.chapter04

object Scala03_for {
    def main(args: Array[String]): Unit = {
        
        // TODO for循环
        /*
          java :
          for ( int i = 0; i < 10; i=i+2 ) {
              // 循环体
              0,1,2,3,4,5,6,7,8,9
          }
          for ( Object obj : list ) {
          
          }
         */
        // Scala
        // 1. 1 + 5  => 1.+(5)
        //    1 to 5 => 1.to(5) => Range(集合)：从1到5
        // 2. <- : 指向
        // to : 前后闭合
//        for ( i <- 1 to 5 ) {
//            println(i)
//        }
        // until : 前闭后开
        for ( i <- 1 until 5 ) {
            println(i)
        }
    }
}
