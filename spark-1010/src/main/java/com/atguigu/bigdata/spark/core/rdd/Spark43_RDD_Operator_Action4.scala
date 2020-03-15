package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark43_RDD_Operator_Action4 {
    def main(args: Array[String]): Unit = {

      val conf = new SparkConf().setMaster("local[*]").setAppName("action")
      val sc = new SparkContext(conf)

      // TODO Spark - RDD - 算子 - 行动
      val rdd:RDD[Int] = sc.makeRDD(List(1,2,3,4),2)

      // TODO aggregate：聚合数据
      // aggregate算子会在分区间计算时也使用zeroValue
      // 10 + 1 + 2 => 13
      // 10 + 3 + 4 => 17
      // 10 + 13 + 17 => 40
      val i:Int = rdd.aggregate(10)(_+_,_+_)
      // TODO fold：聚合数据，是aggregate简化版本
      val j:Int = rdd.fold(10)(_+_)

      println("i = " + i)
      println("j = " + j)

      sc.stop()
    }
}
