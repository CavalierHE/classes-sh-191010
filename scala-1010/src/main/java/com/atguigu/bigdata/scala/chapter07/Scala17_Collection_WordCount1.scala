package com.atguigu.bigdata.scala.chapter07

object Scala17_Collection_WordCount1 {
  def main(args: Array[String]): Unit = {
      // TODO Scala - 集合 - WordCount
      // 需求：从集合中获取单词出现的频率，取其中出现次数
      // 最多的三个单词
      val stringList = List(
          "Hello Hadoop Hive Scala Spark",
          "Hello Hadoop Hive Scala",
          "Hello Hadoop Hive",
          "Hello Hadoop",
          "Hello"
      )
    
      // 函数链
      // 操作链
      // 方法链
      stringList
        .flatMap(_.split(" "))
        // TODO 如果一个函数得到什么就返回什么的情况下，是不能采用下划线代替参数
        .groupBy(word=>word)
        // TODO 如果想要key保持不变，仅仅对value进行转换，可以采用mapValues方法
        .mapValues(list=>list.size)
//        .map(
//            t => {
//                (t._1, t._2.size)
//            }
//        )
        .toList.sortWith(_._2 > _._2)
        .take(3)
        .foreach(println)
  }
}
















