package com.atguigu.bigdata.scala.chapter07

object Scala02_Collection_Array {
  def main(args: Array[String]): Unit = {

    // TODO Scala - 集合
    // Scala中集合分成可变集合和不可变集合
    // Scala中默认声明的集合都是不可变的

    // TODO 构建集合 - 数组
    // 数组应该有类型，如果没有指定类型，那么默认为Object(Nothing)类型
    // 创建数组时，应该指定数据的类型 : [类型]
    val array = new Array[String](3)

    // TODO 访问数组中的元素可以采用小括号加索引的方式
    array(0) = "zhangsan"
    array(1) = "lisi"
    array(2) = "wangwu"

//    println(array)

    // TODO 对数组中的数据进行遍历
//    for (s <- array) {
//        println(s)
//    }
    // 将集合中的元素通过指定字符分隔形成字符串
    println(array.mkString(","))

  }
}
