package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark08_RDD_File_Partition1 {
  def main(args: Array[String]): Unit = {

    // TODO 创建Spark上下文环境对象
    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    // TODO 创建RDD - 基于磁盘文件
    // TODO 读取文件时采用的读取方式是Hadoop的读取方式（按行）
    // val lineRDD:RDD[String] = sc.textFile("input/2.txt",2)
    // TODO textFile指定分区时表示的含义为最小分区数，就意味着可能更多

    /*
          // 总的文件字节数
          totalSize
          for (FileStatus file: files) {
          totalSize += file.getLen
          }
          //每一个切片（分区）应该保存的字节数(偏移量)
          val goalSize: Long = totalSize / (if (numSplits == 0)  { 1}
else  { numSplits})

          //
          101 / 100 = 1
          // 判断剩余字节是否需要进行新的分区
         (bytesRemaining.toDouble) / splitSize(goalSize) > SPLIT_SLOP(0.1)

         totalSize = 10
         numSplits = 3
         goalSize = 3

         分区数量 = 4
         分区数据存储：以数据偏移量存储
         0+3 => 0,1,2,3 => 1,2
         3+6 => 3,4,5,6 => 3
         6+9 => 6,7,8,9 => 4
         9+1

        TODO ： 文件分区的数量算法和文件分区数据的读取规则是不一样的。
       */

    val lineRDD:RDD[String] = sc.textFile("input/1*.txt",3)

    lineRDD.saveAsTextFile("output")

    sc.stop()
  }
}
