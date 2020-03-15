package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark32_RDD_WordCount_4 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    // TODO Spark - RDD - 算子 - 转换 - aggregateByKey
    val numRDD1:RDD[(String,Int)] =
      sc.makeRDD(List(("a", 3), ("a", 2), ("c", 4), ("b", 3), ("c", 6), ("c", 8)),2)

    // WordCount
    val aggRDD:RDD[(String,Int)] =
      numRDD1.aggregateByKey(0)((x,y)=>x+y,(x,y)=>x+y)
    println(aggRDD.collect().mkString(","))

    sc.stop()
  }
}
