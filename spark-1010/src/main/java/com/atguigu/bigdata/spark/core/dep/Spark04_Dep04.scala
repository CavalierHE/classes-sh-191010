package com.atguigu.bigdata.spark.core.dep

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark04_Dep04 {
  def main(args: Array[String]): Unit = {

    // TODO : Stage  阶段
    // 阶段如何划分？
    // Spark需要根据依赖关系进行阶段划分
    // 阶段的数量 = 1 + N(shuffle的个数) = 2
    // Job (1) => Stage(N)

    val conf = new SparkConf().setMaster("local[*]").setAppName("dep")

    val sc = new SparkContext(conf)

    val lineRDD: RDD[String] = sc.textFile("input/1.txt")

    val wordRDD: RDD[String] = lineRDD.flatMap(line=>line.split(" "))

    val wordToOneRDD: RDD[(String, Int)] = wordRDD.map(word=>(word, 1))

    val wordToSumRDD: RDD[(String, Int)] = wordToOneRDD.reduceByKey( (x, y) => x + y )

    wordToSumRDD.collect().foreach(println)

    sc.stop()
  }
}
