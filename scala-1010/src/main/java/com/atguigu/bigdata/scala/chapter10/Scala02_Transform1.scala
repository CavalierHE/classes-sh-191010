package com.atguigu.bigdata.scala.chapter10

object Scala02_Transform1 {
  def main(args: Array[String]): Unit = {
    // TODO Scala - 隐式转换 - 自动转换
    implicit def transform(d:Double): Int = {
      d.toInt
    }

//    implicit def test(d:String): Int = {
//      d.toInt
//    }

    // TODO 在同一个作用域范围内，相同的转换规则只能出现一次
    // TODO 隐式转换只能是一次性的转换，不能采用链接的方式
    val a:Int = 20.0
    println(a)
  }
}

