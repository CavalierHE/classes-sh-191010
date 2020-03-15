package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark45_RDD_WordCount_7 {
    def main(args: Array[String]): Unit = {

      val conf = new SparkConf().setMaster("local[*]").setAppName("action")
      val sc = new SparkContext(conf)

      // TODO Spark - RDD - 算子 - 行动
      val rdd:RDD[String] = sc.makeRDD(List("Hello","Hello","Hello"))

      // TODO countByKey：相同的key出现的次数

      // WordCount - 7
      println(rdd.map((_,1)).countByKey())

      sc.stop()
    }
}
