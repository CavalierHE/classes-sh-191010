package com.atguigu.bigdata.scala.chapter07

import scala.collection.mutable.ListBuffer

object Scala08_Collection_ListBuffer {
  def main(args: Array[String]): Unit = {

    // TODO Scala - 集合 - ListBuffer
    val buffer: ListBuffer[Int] = ListBuffer(1,2,3,4)

    // 增加数据
    buffer.append(5,6,7)
    buffer.insert(1,8)

    // 修改数据
    //buffer.update(1,9)
    //buffer(1) = 9

    // 删除数据
    buffer.remove(1)
    println(buffer.mkString(","))
  }
}
