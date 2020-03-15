package com.atguigu.bigdata.spark.core.dep

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark03_Dep03 {
  def main(args: Array[String]): Unit = {

    // 当前Main方法所执行的程序，称之为Application应用程序
    // 其中可以获取Spark上下文环境对象，所以将这个类称之为Driver类
    val conf = new SparkConf().setMaster("local[*]").setAppName("dep")

    val sc = new SparkContext(conf)

    val lineRDD: RDD[String] = sc.textFile("input/1.txt")

    val wordRDD: RDD[String] = lineRDD.flatMap(line=>line.split(" "))

    val wordToOneRDD: RDD[(String, Int)] = wordRDD.map(word=>(word, 1))

    val wordToSumRDD: RDD[(String, Int)] = wordToOneRDD.reduceByKey( (x, y) => x + y )

    // Job 表示作业，当RDD执行行动算子的时候，会触发作业的执行
    // new ActiveJob
    wordToSumRDD.collect().foreach(println)
    wordToSumRDD.collect().foreach(println)

    // Application (1) -> Job(N)

    sc.stop()
  }
}
