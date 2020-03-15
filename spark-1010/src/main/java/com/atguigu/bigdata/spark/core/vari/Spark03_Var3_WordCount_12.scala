package com.atguigu.bigdata.spark.core.vari

import org.apache.spark.util.AccumulatorV2
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable

object Spark03_Var3_WordCount_12 {
  def main(args: Array[String]): Unit = {
    // TODO 使用累加器实现WordCount

    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val rdd = sc.makeRDD(List("Hello", "Hello", "Hello", "Spark", "Spark"))

    // 使用累加器
    val acc = new WordCountAccumulator
    // 注册累加器
    sc.register(acc, "wordCount")

    rdd.foreach(
      word => {
        acc.add(word)
      }
    )

    // 获取累加器的值
    println( acc.value )

    sc.stop()
  }

  // 自定义累加器
  // 1. 继承AccumulatorV2，并设定泛型
  // 2. 重写累加器的抽象方法
  class WordCountAccumulator extends AccumulatorV2[String, mutable.Map[String, Long]]{

    var map : mutable.Map[String, Long] = mutable.Map()

    // 累加器是否为初始状态
    override def isZero: Boolean = {
      map.isEmpty
    }

    // 复制累加器
    override def copy(): AccumulatorV2[String, mutable.Map[String, Long]] = {
      new WordCountAccumulator
    }

    // 重置累加器
    override def reset(): Unit = {
      map.clear()
    }

    // 向累加器中增加数据 (In)
    override def add(word: String): Unit = {
      // 查询map中是否存在相同的单词
      // 如果有相同的单词，那么单词的数量加1
      // 如果没有相同的单词，那么在map中增加这个单词
      map(word) = map.getOrElse(word, 0L) + 1L
    }

    // 合并累加器
    override def merge(other: AccumulatorV2[String, mutable.Map[String, Long]]): Unit = {

      val map1 = map
      val map2 = other.value

      // 两个Map的合并
      map = map1.foldLeft(map2)(
        ( innerMap, kv ) => {
          innerMap(kv._1) = innerMap.getOrElse(kv._1, 0L) + kv._2
          innerMap
        }
      )
    }

    // 返回累加器的结果 （Out）
    override def value: mutable.Map[String, Long] = map
  }
}
