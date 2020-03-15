package com.atguigu.bigdata.scala.chapter07

object Scala03_Collection_Array1 {
  def main(args: Array[String]): Unit = {

    // TODO Scala - 集合 - 数组
    // Array是不可变集合，如果对集合进行数据的处理，会产生新的集合
    val array = new Array[Int](3)
    array(0) = 0
    array(1) = 1
    array(2) = 2

    // 在原来集合的最后添加新的数据，产生新的集合
    val ints1: Array[Int] = array :+ 5
    // 在原来集合的最前面添加新的数据，产生新的集合
    val ints2: Array[Int] = 5 +: array
    // println(array == ints)
    println(ints1.mkString(","))
    println(ints2.mkString(","))
  }
}
