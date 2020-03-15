package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark34_RDD_WordCount_5 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    // TODO Spark - RDD - 算子 - 转换 - aggregateByKey
    val numRDD1:RDD[(String,Int)] =
      sc.makeRDD(List(("a", 3), ("a", 2), ("c", 4), ("b", 3), ("c", 6), ("c", 8)),2)

    // WordCount - 5
    val rdd: RDD[(String, Int)] = numRDD1.foldByKey(0)(_+_)

    println(rdd.collect().mkString(","))

    sc.stop()
  }
}
