package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark02_RDD_Make {
  def main(args: Array[String]): Unit = {

    // TODO 创建Spark上下文环境对象
    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    // TODO 创建RDD - 基于内存
    // 1.创建集合
    val list = List(1,2,3,4)
    // 2.创建RDD
    //    parallelize：并行
    val numRDD:RDD[Int] = sc.parallelize(list)
    // 3.执行RDD
    val ints:Array[Int] = numRDD.collect()

    ints.foreach(println)

    // TODO 释放连接
    sc.stop()
  }
}
