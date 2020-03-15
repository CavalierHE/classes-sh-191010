package com.atguigu.bigdata.spark.core.dep

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark02_Dep02 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    // TODO 依赖关系
    // OneToOneDependency ： 窄依赖
    // 没有shuffle的依赖，上一个RDD中一个分区的数据放置在下一个RDD的同一个分区中
    // ShuffleDependency ： 宽依赖
    // 有shuffle的依赖，上一个RDD中一个分区的数据被打乱重新组合到下一个RDD的不同分区中
    val lineRDD: RDD[String] = sc.textFile("input/1.txt")
    println(lineRDD.dependencies)
    println("-----------------------------")

    // lineRDD <= OneToOneDependency =>wordRDD
    val wordRDD: RDD[String] = lineRDD.flatMap(line=>line.split(" "))
    println(wordRDD.dependencies)
    println("-----------------------------")

    // wordRDD <= OneToOneDependency => wordToOneRDD
    val wordToOneRDD: RDD[(String, Int)] = wordRDD.map(word=>(word, 1))
    println(wordToOneRDD.dependencies)
    println("-----------------------------")

    // 每一个RDD都保存了之前的所有依赖关系(血缘关系)
    // 一旦RDD操作失败，Spark可以根据依赖关系重新加载数据，重新执行任务
    // wordToOneRDD <= ShuffleDependency => wordToSumRDD
    val wordToSumRDD: RDD[(String, Int)] = wordToOneRDD.reduceByKey( (x, y) => x + y )
    println(wordToSumRDD.dependencies)
    println("-----------------------------")

    wordToSumRDD.collect().foreach(println)

    sc.stop()
  }
}
