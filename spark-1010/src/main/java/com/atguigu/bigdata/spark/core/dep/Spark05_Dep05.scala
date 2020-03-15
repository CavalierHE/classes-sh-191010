package com.atguigu.bigdata.spark.core.dep

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark05_Dep05 {
  def main(args: Array[String]): Unit = {

    // TODO : Task 任务
    // 一个Job中到底有多少个任务
    // Spark在提交阶段的时候，会将这个阶段最后的一个RDD中的分区进行处理
    // 转换为任务
    // 所以阶段中任务的数量 = 一个阶段最后RDD的分区数量
    // TODO 一个Job中任务数量 = 所有阶段中的任务数量总和

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
