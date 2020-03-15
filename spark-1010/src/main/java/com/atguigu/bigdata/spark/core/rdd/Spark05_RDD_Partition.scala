package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark05_RDD_Partition {
  def main(args: Array[String]): Unit = {

    // TODO 创建Spark上下文环境对象
    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    // TODO 创建RDD - 基于内存
    val list = List(1,2,3,4)
    // 对数据进行分区的时候，会根据集合中元素的数量以及分区数量平均分配

    /*
       TODO 集合中的数据到底如何分区，取决于下面的代码：
        length = 4， numSlices = 3
      def positions(length: Long, numSlices: Int): Iterator[(Int, Int)] = {
        // （0，1，2）=> i => (start, end)
        // i = 0 => (0, 1)
        // i = 1 => (1, 2)
        // i = 2 => (2, 4)
        (0 until numSlices).iterator.map { i =>
          val start = ((i * length) / numSlices).toInt
          val end = (((i + 1) * length) / numSlices).toInt
          (start, end)
        }
      }
       */
    val numRDD:RDD[Int] = sc.makeRDD(list,3)
    numRDD.saveAsTextFile("output")

    // TODO 释放连接
    sc.stop()
  }
}
