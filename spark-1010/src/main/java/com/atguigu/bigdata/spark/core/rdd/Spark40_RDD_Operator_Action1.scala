package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.{SparkConf, SparkContext}


object Spark40_RDD_Operator_Action1 {
    def main(args: Array[String]): Unit = {

      val conf = new SparkConf().setMaster("local[*]").setAppName("action")
      val sc = new SparkContext(conf)

      // TODO Spark - RDD - 算子 - 行动
      // 一个行动算子会触发整个作业的执行
      // 提交作业等同于提交应用
      // App （1）<--> Job （N）
      val rdd = sc.makeRDD(List(1,2,3,4))

      // collect 就是行动算子，执行作业
      // 行动算子可以多次调用执行，就会产生多个作业
      rdd.collect().foreach(println)
      rdd.collect().foreach(println)
      sc.stop()
    }
}
