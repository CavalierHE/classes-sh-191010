package com.atguigu.bigdata.scala.chapter07

import scala.collection.mutable

object Scala11_Collection_Tuple {
  def main(args: Array[String]): Unit = {
    // TODO Scala - 集合 - Tuple
    // 封装类
    // 用户名 zhangsan 年龄 20 性别 男

    // 封装集合
    // 20，30，40，23，35，27

    // Scala采用一种特殊的数据存储结构来存储无关的数据
    // 这个结构称之为元组（元素的组合）：Tuple
    // 1，zhangsan, xxxx, 20
    // 声明元组：( 元素1，元素2，元素3 )
    val t = (1,"zhangsan","xxx",20)

    // 由于元组中的数据都是无关的，所以只能通过数据的顺序进行访问
    // 访问方式：元组._顺序号
    // 元组中最大的数据容量为22，类型没有限制
//    println(t._1)
//    println(t._2)
//    println(t._3)
//    println(t._4)

    // 对元祖数据进行遍历
    val iterator:Iterator[Any] = t.productIterator
    while (iterator.hasNext){
      println(iterator.next())
    }

    // 如果元祖中数据的个数只有两个，可以称之为对偶元祖，也可以称之为键值对(KV对)
    val t1 = ("a",1)
    println(Map(t1))
  }
}
