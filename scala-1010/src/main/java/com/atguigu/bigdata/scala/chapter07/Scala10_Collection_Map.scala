package com.atguigu.bigdata.scala.chapter07

import scala.collection.mutable

object Scala10_Collection_Map {
  def main(args: Array[String]): Unit = {
    // TODO Scala - 集合 - Map

    // Map：存储的为KV对数据，无序
    // KV对声明的方式：K -> V
    // 默认使用Map集合是不可变集合
    //val map = Map( "a"->1, "b"->2, "c"->3, "d"->4, "e"->5 )
    // 可变Map集合
    val map = mutable.Map("a"->1,"b"->2)

    // 增加数据
    map.put("c",3)
    map.put("b",6)

    // 获取数据
    // Option : 选项：有值（Some），无值(None)
    // Option专门用于解决空指针异常的场合
    // 如果有值的场合获取Option的值，采用get方法
    // 如果没有值的场合使用get方法获取Option值，会发生错误
    //   java.util.NoSuchElementException: None.get
    // 可以采用getOrElse方法获取默认值
    //val maybeInt: Option[Int] = map.get("a")
    val v:Int = map.getOrElse("a",-1)
    // 修改数据
    //map("a") = 2
    //map.update("a",4)

    // 删除数据
    //map.remove("b")

    println(v)
  }
}
