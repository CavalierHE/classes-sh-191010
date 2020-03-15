package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark07_RDD_File_Partition {
  def main(args: Array[String]): Unit = {

    // TODO 创建Spark上下文环境对象
    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    // TODO 创建RDD - 基于磁盘文件
    // 从指定的路径中获取数据，读取文件时一般采用行读取(hadoop读取方式)
    // textFile方法可以设定文件的分区，如果不设定，那么采用默认值
    // 默认值：minPartitions: Int = defaultMinPartitions
    // defaultMinPartitions: Int = math.min(defaultParallelism, 2)
    val lineRDD:RDD[String] = sc.textFile("input/1.txt")

    lineRDD.saveAsTextFile("output")

    sc.stop()
  }
}
