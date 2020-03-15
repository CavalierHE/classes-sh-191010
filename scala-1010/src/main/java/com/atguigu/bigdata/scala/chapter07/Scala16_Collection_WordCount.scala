package com.atguigu.bigdata.scala.chapter07

object Scala16_Collection_WordCount {
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
    
      // TODO 1.将集合中的字符串进行扁平化操作，拆分成一个一个的单词
      // String => word
      val wordList = stringList.flatMap(s=>s.split(" "))
      // TODO 2.将相同的单词放置在一个组中
      val wordToListMap = wordList.groupBy(word=>word)
      // TODO 3.将分组后的数据进行结构的转换
      // (word,List) => (word,count)
      val wordToCountMap = wordToListMap.map(
          t => {
            (t._1, t._2.size)
          }
      )
      // TODO 4.将转换结构后的数据进行排序
      val sortList = wordToCountMap.toList.sortWith(
          (left, right) => {
            left._2 > right._2
          }
      )
      // TODO 5.将排序后的数据获取前三名：TopN
      val result = sortList.take(3)

      // TODO 6.将结果打印在控制台上
      result.foreach(println)
  }
}
















