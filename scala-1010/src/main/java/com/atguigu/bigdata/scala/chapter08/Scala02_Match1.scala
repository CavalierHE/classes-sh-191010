package com.atguigu.bigdata.scala.chapter08

object Scala02_Match1 {

  def main(args: Array[String]): Unit = {
    // Scala - 模式匹配
    var a:Int = 10
    var b:Int = 20
    var operator:Char = '*'

    var result = operator match {
      case '+' => a + b
      case '-' => a - b
      case '*' => a * b
      case '/' => a / b
      case _ => "illegal"
    }

    println(result)
  }
}
