package com.atguigu.bigdata.scala.chapter07

import scala.collection.mutable.ArrayBuffer

object Scala05_Collection_ArrayBuffer {
  def main(args: Array[String]): Unit = {

    // TODO Scala - 集合 - 可变数组
    val buffer = new ArrayBuffer[Int]()
    //val buffer = ArrayBuffer(1,2,3,4)

    // 追加数据
    buffer.append(1)
    buffer.append(2)
    buffer.append(3)

    //1,6,2,3
    //buffer.insert(1,6)

    // 修改数据
    //buffer.update(1,5)  //1,5,2,3
    //buffer(1) = 5 //1,5,2,3

    // 删除数据：根据索引删除数据，并且可以指定删除的数量
    //buffer.remove(1)
    //buffer.remove(1,2)
    //buffer.remove(1,3)  //java.lang.IndexOutOfBoundsException: 1

    // 遍历集合
    println(buffer.mkString(","))
  }
}
