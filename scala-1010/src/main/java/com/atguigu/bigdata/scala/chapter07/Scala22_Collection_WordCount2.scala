package com.atguigu.bigdata.scala.chapter07

import scala.collection.mutable

object Scala22_Collection_WordCount2 {
  def main(args: Array[String]): Unit = {
      // TODO Scala - WordCount
      val list = List(
        ("Hello Scala Spark Hadoop",4),
        ("Hello Scala Spark",3),
        ("Hello Scala",2),
        ("Hello",1)
      )
      // 需求：统计单词出现的频率，并取出现次数排名前三

      // TODO 1.如何将现有的数据格式转换为之前的数据格式
      // ("Hello Scala Spark Hadoop", 4) =>
      // "Hello Scala Spark Hadoop Hello Scala Spark Hadoop Hello Scala Spark Hadoop Hello Scala Spark Hadoop"
      // (s,cnt) => s
      // 字符串对象有一个乘法运算，表示让字符串重复出现
      // "*" * 2
//    val strings = list.map(
//      t => {
//        val s = t._1
//        val cnt = t._2
//        (s + " ") * cnt
////        var s1 = ""
////        for (i <- 1 to cnt) {
////          s1 += " " + s
////        }
////        s1
//      }
//    )
//    println(strings)

      // TODO 2. 将数据进行转换
      // ("Hello Scala Spark Hadoop", 4) => (Hello,4),(Scala,4),(Spark,4),("Hadoop",4)
      // ("Hello Scala Spark", 3)        => (Hello,3),(Scala,3),(Spark,3)
      // ("Hello Scala", 2)              => (Hello,2),(Scala,2)
      // ("Hello", 1)                    => (Hello,1)
      val wordToCountList = list.flatMap(
        t => {
          val s = t._1
          val cnt = t._2
          // word => (word,cnt)
          s.split(" ").map(
            word => {
              (word, cnt)
            }
          )
        }
      )

      // 将相同单词放置在一个组中
      val wordGroupMap = wordToCountList.groupBy(_._1)
      // 将分组后的数据进行结构的转换
      //（word, List(word, cnt)）=> (word, List(cnt)) => (word, sum)
      val wordToSumMap = wordGroupMap.mapValues(
        list => {
          list.map(_._2).sum
        }
      )

      val sortList = wordToSumMap.toList.sortWith(
        (left, right) => {
          left._2 > right._2
        }
      )

      println(sortList.take(3))
  }
}
















