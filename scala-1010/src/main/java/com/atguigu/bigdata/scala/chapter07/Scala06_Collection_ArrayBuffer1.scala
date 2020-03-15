package com.atguigu.bigdata.scala.chapter07

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Scala06_Collection_ArrayBuffer1 {
  def main(args: Array[String]): Unit = {

    // TODO Scala - 集合 - 可变数组和不可变数组的互换
    val array = Array(1,2,3)
    // 不可变数组 => 可变数组
    val buff: mutable.Buffer[Int] = array.toBuffer

    val buffer = ArrayBuffer(1,2,3,4)
    // 可变数组 => 不可变数组
    val array1: Array[Int] = buffer.toArray
  }
}
