package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark36_RDD_WordCount_6 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    // TODO Spark - RDD - 算子 - 转换 - combineByKey
    val numRDD1:RDD[(String, Int)] =
      sc.makeRDD(List(("a", 88), ("b", 95), ("a", 91), ("b", 93), ("a", 95), ("b", 98)), 2)

    // WordCount - 6
    println(
      numRDD1.combineByKey(
        num => num, //转换数据的结构
        (t:Int,num) => { // 分区内计算规则
          t + num
        },
        (t1:Int,t2:Int) => { // 分区间计算规则
          t1 + t2
        }
      ).collect().mkString(",")
    )

    sc.stop()
  }
}
