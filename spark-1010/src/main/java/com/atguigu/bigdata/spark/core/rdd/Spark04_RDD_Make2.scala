package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark04_RDD_Make2 {
  def main(args: Array[String]): Unit = {

    // TODO 创建Spark上下文环境对象
    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    // TODO 创建RDD - 基于内存
    // 1.创建集合
    val list = List(1)
    // 2.创建RDD
    // makeRDD方法会调用parallelize方法，所以和parallelize方法没有区别
    // 默认数据的分区数量为机器的总核数，可以传参动态改变
    val numRDD:RDD[Int] = sc.makeRDD(list,9)
    // 3.将数据保存到文件中
    //    数据保存以分区的方式保存
    numRDD.saveAsTextFile("output")

    // TODO 释放连接
    sc.stop()
  }
}
