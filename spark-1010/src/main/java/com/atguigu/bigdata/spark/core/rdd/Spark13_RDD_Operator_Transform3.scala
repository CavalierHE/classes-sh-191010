package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark13_RDD_Operator_Transform3 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val numRDD:RDD[Int] = sc.makeRDD(List(1,4,2,3),2)

    // TODO - Spark - 算子 - 转换 - glom
    // 需求：将每个分区的最大值取出后求和
//    val num2RDD:Array[Int] = numRDD.mapPartitions(
//      list => List(list.max).iterator
//    ).collect
//
//    println(num2RDD.sum)

    val glomRDD:RDD[Array[Int]] = numRDD.glom()
    val mapRDD:RDD[Int] = glomRDD.map(array => array.max)
    println(mapRDD.collect.sum)

    sc.stop()
  }
}
