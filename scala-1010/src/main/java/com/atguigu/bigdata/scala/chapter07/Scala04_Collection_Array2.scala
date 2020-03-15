package com.atguigu.bigdata.scala.chapter07

object Scala04_Collection_Array2 {
  def main(args: Array[String]): Unit = {

    // TODO Scala - 集合 - 数组
    // Array是不可变集合，如果对集合进行数据的处理，会产生新的集合
//    val array = new Array[Int](3)
//    array(0) = 0
//    array(1) = 1
//    array(2) = 2

    // 更新数据
    //array(1) = 4

    // 调用集合的update方法和array(0) = x完全相同
    //array.update(1,4)

//    println(array.mkString(","))

    // TODO 第二种创建数组的方式
    // 不使用new的方式创建集合对象，等同于调用集合伴生对象的apply方法
    val ints = Array(1,2,3,4)
    println(ints.mkString(","))
  }
}
