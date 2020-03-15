package com.atguigu.bigdata.scala.chapter04

import scala.util.control.Breaks._

object Scala06_Break {
    def main(args: Array[String]): Unit = {
        
        // TODO break continue
        // Scala中没有continue关键字，可以采用if判断进行代替。
        /*
           for ( int i = 0; i < 5; i++ ) {
               if ( i == 2 ) {
                   continue;
               }
               sout("i = " + i)
           }
           for ( int i = 0; i < 5; i++ ) {
               if ( i != 2 ) {
                   sout("i = " + i)
               }
           }
        
        // break关键字在逻辑处理中必不可少，但是不是面向对象的语法。
        // 在Scala语言中没有break关键字，采用对象方法的方式实现同样的逻辑。
        // break : 中断（跳出）循环
           for ( int i = 0; i < 5; i++ ) {
               if ( i == 2 ) {
                   break;
               }
               sout("i = " + i)
           }
         */
        // Scala采用异常处理的方式实现循环中断的语法。
//        Breaks.breakable {
//            for ( i <- 1 to 5 ) {
//                if ( i == 2 ) {
//                    Breaks.break();
//                }
//                println("i = " + i)
//            }
//        }
        breakable {
            for ( i <- 1 to 5 ) {
                if ( i == 2 ) {
                    break;
                }
                println("i = " + i)
            }
        }
    }
}
