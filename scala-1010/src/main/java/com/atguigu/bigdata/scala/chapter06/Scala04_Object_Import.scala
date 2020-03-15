package com.atguigu.bigdata.scala.chapter06

import java.util._
import java.sql.{Date=>_,Array=>_,_}
import java.lang.{String=>S}
import java.util
import java.util.{ArrayList, HashMap}


object Scala04_Object_Import {

  def main(args: Array[String]): Unit = {

    // TODO - Scala -面向对象 - Import
    // java中import的作用：导类、静态导入类的静态属性和静态方法
    // java中import关键字没有那么强大，但是不能舍弃
    // TODO 1.哪些包中的类无需导入
    // 1.1 java.lang包中的类无需导入
    // 1.2 scala包中的类无需导入
    // 1.3 scala.Predef中的所有属性和方法无需导入，可以直接使用
    // TODO 2.导入一个包中所有的类，采用下划线来代替星号
//    import java.util._
//    new Date()
    // TODO 3.可以将一个包中多个类在同一行中导入
//    new ArrayList()
//    new HashMap()
    // TODO 4.Scala中才是真正的导包
//    new util.ArrayList()
    // TODO 5.不同的包有相同名称类，Scala可以使用特殊的语法隐藏类
//    import java.sql.{Date=>_,Array=>_,_}
//    println(new Date)
    // TODO 6.Scala支持类的重命名
//    import java.lang.{String=>S}
//    val b:S = "abc"
  }

}

