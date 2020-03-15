package com.atguigu.bigdata.scala.chapter07

object WordCount_Test {
  def main(args: Array[String]): Unit = {
    val stringList = List(
      List( ("Hello World Hadoop Hive", 4), ("Hello Spark Scala Hive", 4) ),
      List( ("Hello World Hive", 3), ("Hello Spark  Hive", 2) ),
      List( ("Hello World Hadoop", 2), ("Hello Scala Hive", 3) ),
      List( ("Hello Hadoop Hive", 1), ("Spark Scala Hive", 1) )
    )

    //从上面集合中获取单词出现的频率，并取以H开头的词频的前两名

    val wordList = stringList.flatten
    val wordToCountList = wordList.flatMap(
      t => {
        val s = t._1
        val cnt = t._2
        s.split(" ").map(
          word => {
            (word, cnt)
          }
        )
      }
    )

    val wordGroupMap = wordToCountList.groupBy(_._1)

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

    val resultList = sortList.filter(_._1.startsWith("H"))

    println(resultList.take(2))
  }
}
