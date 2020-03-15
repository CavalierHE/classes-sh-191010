package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark37_RDD_Operator_Transform21 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    // TODO Spark - RDD - 算子 - 转换 - combineByKey
    val numRDD1:RDD[(String, Int)] =
      sc.makeRDD(List(("a", 88), ("b", 95), ("a", 91), ("b", 93), ("a", 95), ("b", 98)), 2)

    println(numRDD1.sortByKey(true).collect().mkString(","))

    sc.stop()
  }
}
