package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark44_RDD_Operator_Action5 {
    def main(args: Array[String]): Unit = {

      val conf = new SparkConf().setMaster("local[*]").setAppName("action")
      val sc = new SparkContext(conf)

      // TODO Spark - RDD - 算子 - 行动
      val rdd:RDD[Int] = sc.makeRDD(List(1,2,2,3,3,4),2)

      // TODO countByKey：相同的key出现的次数
      //println(rdd.map((_,1)).countByKey())

      // TODO countByValue：相同的值出现的次数
      println(rdd.countByValue())

      sc.stop()
    }
}
