package com.atguigu.bigdata.scala.chapter07

object Scala19_Collection_Operator4 {
  def main(args: Array[String]): Unit = {
      // TODO Scala - 集合 - 数据操作方法（函数）
      val list = List(1,2,3,4,5)

      // TODO 1.简化，规约
      // 1 + 1 + 1 + 1 = 4
      // op:(A1, A1) => A1
      // op:(String, String) => String
      // reduce方法的底层使用的就是reduceLeft
      val result = list.reduce(_-_)
      //println(result)

      // op:(B, Int) => B
      // 1 + 2 + 3 + 4 + 5
      // ((((1 + 2) + 3) + 4) + 5)
      val result1:Int = list.reduceLeft(_+_)
      println(result1)

      val result2:Int = list.reduceRight(_-_)
      println(result2)
  }
}
















