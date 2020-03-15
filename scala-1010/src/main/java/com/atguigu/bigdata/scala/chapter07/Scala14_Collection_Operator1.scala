package com.atguigu.bigdata.scala.chapter07

object Scala14_Collection_Operator1 {
  def main(args: Array[String]): Unit = {
      // TODO Scala - 集合 - 数据操作方法（函数）
      val list = List(1,2,3,4,5,6)

      // 头
      //println(list.head)
      // 尾，递归
      //println(list.tail)

      // 反转
      //println(list.reverse)
      //println(list.reverse.head)

      // 最后一个
      //println(list.last)

      // 初始
      //var list1 = List(1)
      //println(list.init)

      // 包含
      //println(list.contains(5))

      // 去重
      //list.distinct
      //println(list.distinct)

      // 拿
      //println(list.take(2))

      // 从右边拿
      //println(list.takeRight(2))

      // 丢弃
      println(list.drop(2))
      //println(list.dropRight(2))
  }
}

















