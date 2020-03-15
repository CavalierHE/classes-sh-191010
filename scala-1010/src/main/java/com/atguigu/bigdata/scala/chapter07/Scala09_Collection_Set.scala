package com.atguigu.bigdata.scala.chapter07

import scala.collection.mutable

object Scala09_Collection_Set {
  def main(args: Array[String]): Unit = {

    // TODO Scala - 集合 - Set
    // 数据不可重复，无序
    // Set默认情况下使用的是不可变集合
    //val set = Set(1,2,3,4,5,6,7,8)
    val set = mutable.Set(1,2,3,4,5,6,7,8)

    // 增加数据
//    set.add(5)
    // 增加数据并产生新的集合
//    val set1 = set + 3
//    println(set == set1)

    // 增加数据不产生新的集合
//    val set2 = set += 4
//    println(set == set2)

    // 删除数据：删除指定的数据
//    set.remove(6)
//    val set1 = set.-(3)

    // 修改数据
    // 向集合中添加数据
    set.update(9,true)
    // 从集合中删除数据
    set.update(7,false)

    println(set)
    println(set.mkString(","))
//    println(set1.mkString(","))

  }
}
