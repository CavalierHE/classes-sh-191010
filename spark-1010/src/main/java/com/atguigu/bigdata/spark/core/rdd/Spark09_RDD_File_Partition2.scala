package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark09_RDD_File_Partition2 {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    // 分区数量
    // 每个分区的数据存储
    // totalsize = 7 + 7 = 14
    // 14 / 3 = 4
    // 7 / 4 = 1 + 1 = 4

    // TODO 单一文件分区，分解，存储数据的规则
    // 0 => 0 + 4   => 1,2
    // 1 => 4 + 4   => 3,1
    // 2 => 8 + 4   => 2
    // 3 => 12 + 2  => 3
    // TODO 多文件分区，分解，存储数据的规则
    // 分区以文件为单位
    // 0 => 0 + 4 => 1,2
    // 1 => 4 + 3 => 3
    // 2 => 0 + 4 => 1,2
    // 3 => 4 + 3 => 3

    val lineRDD:RDD[String] = sc.textFile("input/1*.txt",3)

    lineRDD.saveAsTextFile("output")

    sc.stop()
  }
}
