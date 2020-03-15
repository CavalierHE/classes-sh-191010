package com.atguigu.bigdata.scala.chapter09

object Scala01_Exception {
  def main(args: Array[String]): Unit = {
    // Scala - 异常
    // 进行异常匹配时，一般将范围小的异常优先匹配，case语句放置在前面
    try {
      val i = 10 / 0
    } catch {
      case e: ArithmeticException => {
        println("除数为零算术异常") // 2
      }
      case e:Exception => {
        println("异常") // 1
      }
    } finally {
      println("xxxxx")
    }
  }
}
