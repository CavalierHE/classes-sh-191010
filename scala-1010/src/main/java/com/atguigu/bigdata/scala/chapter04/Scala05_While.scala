package com.atguigu.bigdata.scala.chapter04

object Scala05_While {
    def main(args: Array[String]): Unit = {
        
        // TODO while循环
        /*
          java :
              while ( 条件表达式 ) {
                  // 循环体
                  // 条件更新表达式
              }
              
              do {
                  // 循环体
                  // 条件更新表达式
              } while ( 条件表达式 )
        */
        // Scala
        var num = 0
        while ( num < 5 ) {
            println("num = " + num)
            num += 1
        }
        
        do {
            println("num = " + num)
            num += 1
        } while ( num < 5 )
    }
}
