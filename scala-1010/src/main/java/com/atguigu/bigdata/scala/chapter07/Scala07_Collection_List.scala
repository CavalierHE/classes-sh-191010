package com.atguigu.bigdata.scala.chapter07

object Scala07_Collection_List {
  def main(args: Array[String]): Unit = {
    // TODO Scala - 集合 - List
    // Seq => List
    // 创建List集合
//    val list = List(1)
//
//    val ints = list :+ 2
//    println(list == ints)
//
//    println(list.mkString(","))

    // 空集合 ： Nil
//    val list = Nil
//    val list1 = 1::2::3::Nil
//    println(list1)

    val list1 = List(1,2)
    val list2 = List(3,4)

    val list3 = list1::list2::Nil
    println(list3)

    // 如果将一个数据拆分成一个一个的个体来使用的操作，称之为扁平化
    val list4 = list1:::list2:::Nil
    println(list4)
  }
}
