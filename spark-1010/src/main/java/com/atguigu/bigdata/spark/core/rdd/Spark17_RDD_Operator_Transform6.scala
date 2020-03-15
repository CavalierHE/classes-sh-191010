package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark17_RDD_Operator_Transform6 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val numRDD:RDD[Int] = sc.makeRDD(List(1,1,2,2),2)

    // TODO - Spark - 算子 - 转换 - distinct
    // 底层原理
    // map(x => (x, null)).reduceByKey((x, y) => x, numPartitions).map(_._1)
    // 1 => (1, null)
    // 1 => (1, null)
    // 2 => (2, null)
    // 2 => (2, null)
    // =>
    // (1, (null, null)) => (1, null) => 1
    // (2, (null, null)) => (2, null) => 2
    val num2RDD:RDD[Int] = numRDD.distinct()

    num2RDD.collect().foreach(println)

    sc.stop()
  }
}
