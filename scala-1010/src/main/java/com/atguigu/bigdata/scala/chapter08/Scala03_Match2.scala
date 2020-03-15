package com.atguigu.bigdata.scala.chapter08

object Scala03_Match2 {

  def main(args: Array[String]): Unit = {
    // Scala - 模式匹配
    // 模式守卫
    // 模式匹配不一定仅仅匹配固定的值，也可以匹配类型
    def abs(x:Int) = {
      x match {
        case i:Int if i >= 0 => i
        case j:Int if j <= 0 => -j
        case _ => "type illegal"
      }
    }

    println(abs(-5))
  }
}
