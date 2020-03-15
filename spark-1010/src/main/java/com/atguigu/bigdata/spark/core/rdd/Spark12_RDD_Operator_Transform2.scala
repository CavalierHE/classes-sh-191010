package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark12_RDD_Operator_Transform2 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val numRDD:RDD[String] = sc.makeRDD(List("a b c","a b"),2)

    // TODO - Spark - 算子 - 转换 - flatMap
    val flatRDD:RDD[String] = numRDD.flatMap(s=>s.split(" "))

    flatRDD.collect.foreach(println)

    sc.stop()
  }
}
