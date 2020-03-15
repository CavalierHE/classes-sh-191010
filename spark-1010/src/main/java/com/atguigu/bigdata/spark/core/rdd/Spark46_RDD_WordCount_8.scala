package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark46_RDD_WordCount_8 {
    def main(args: Array[String]): Unit = {

      val conf = new SparkConf().setMaster("local[*]").setAppName("action")
      val sc = new SparkContext(conf)

      // TODO Spark - RDD - 算子 - 行动
      val rdd:RDD[String] = sc.makeRDD(List("Hello","Hello","Hello"))
      // WordCount - 8
      println(rdd.countByValue())

      sc.stop()
    }
}
