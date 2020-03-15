package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark48_RDD_Operator_Action7 {
    def main(args: Array[String]): Unit = {

      val conf = new SparkConf().setMaster("local[*]").setAppName("action")
      val sc = new SparkContext(conf)

      val rdd:RDD[Int] = sc.makeRDD(List(1,2,3,4))

      // collect算子会将Executor端执行的结果采集回到Driver端
      // 所以会在Driver端形成数组
      rdd.collect().foreach(println)
      println("*********************")
      rdd.foreach(println)
      // TODO foreach：分布式打印
      // rdd的方法之外执行的代码是在Driver端执行
      println("*********************")
      rdd.foreach(num=>{
        // rdd的方法内执行的代码是在Executor端执行的
        println(num)
      })

      sc.stop()
    }
}
