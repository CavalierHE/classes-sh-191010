package com.atguigu.bigdata.scala.chapter06

object Scala26_Object_Ext {
  println("scala26...")
  def main(args: Array[String]): Unit = {
    //  TODO 面向对象 - 扩展
    //  枚举类
    println(Color.RED)
  }
}

object Color extends Enumeration {
    val RED = Value(1,"red")
    val YELLOW = Value(2,"yellow")
    val BULE = Value(3,"blue")
}

object Test26 extends App {
    println("xxxxxx")
}