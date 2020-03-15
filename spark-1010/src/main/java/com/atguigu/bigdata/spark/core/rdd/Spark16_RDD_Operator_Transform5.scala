package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark16_RDD_Operator_Transform5 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val numRDD:RDD[Int] = sc.makeRDD(List(1,2,3,4),2)

    // TODO - Spark - 算子 - 转换 - filter
    // 将集合的每一条数据经过逻辑判断后决定是否保留
    // 如果判断结果为true，数据保留，如果结果为false，数据丢弃
    val filterRDD:RDD[Int] = numRDD.filter(num=>num%2==1)

    filterRDD.collect().foreach(println)

    sc.stop()
  }
}
