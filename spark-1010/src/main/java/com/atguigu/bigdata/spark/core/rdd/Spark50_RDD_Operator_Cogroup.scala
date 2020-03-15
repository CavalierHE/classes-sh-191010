package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.{SparkConf, SparkContext}

object Spark50_RDD_Operator_Cogroup {
    def main(args: Array[String]): Unit = {

      val conf = new SparkConf().setMaster("local[*]").setAppName("action")
      val sc = new SparkContext(conf)

      val rdd1 = sc.makeRDD(List(("a", 1), ("b", 1), ("b", 1)))
      val rdd2 = sc.makeRDD(List(("c", 1), ("b", 1)))
      val rdd3 = sc.makeRDD(List(("a", 1), ("b", 1)))

      // shuffle
      val rdd = rdd1.fullOuterJoin(rdd2).fullOuterJoin(rdd3)

      rdd.collect().foreach(println)

      sc.stop
    }
}
