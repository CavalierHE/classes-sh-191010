package com.atguigu.bigdata.spark.core.partition

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark02_Partition02 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("dep")
    val sc = new SparkContext(conf)

    val rdd:RDD[Int] = sc.makeRDD(List(1,2,3,4))
    rdd.map((_,1)).reduceByKey(_+_).repartition(5)
    println(rdd.partitioner)

    sc.stop()
  }
}
