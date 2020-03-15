package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark24_RDD_Operator_Transform13 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val numRDD1:RDD[Int] = sc.makeRDD(List(1,2,3,4),2)
    val numRDD2:RDD[Int] = sc.makeRDD(List(4,5,6,7),2)

    // TODO - Spark - 算子 - 转换 - 双Value类型的数据交互

    // 交集
    val rdd1:RDD[Int] = numRDD1.intersection(numRDD2)

    // 并集
    val rdd2:RDD[Int] = numRDD1.union(numRDD2)

    // 差集
    val rdd3 = numRDD1.subtract(numRDD2)

    //println(rdd1.collect().mkString(","))
    //println(rdd2.collect().mkString(","))
    //println(rdd3.collect().mkString(","))

    // 拉链
    // Can only zip RDDs with same number of elements in each partition
    // Can't zip RDDs with unequal numbers of partitions: List(4, 2)
    val rdd4:RDD[(Int,Int)] = numRDD1.zip(numRDD2)
    println(rdd4.collect().mkString(","))

    sc.stop()
  }
}
