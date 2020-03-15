package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark41_RDD_Operator_Action2 {
    def main(args: Array[String]): Unit = {

      val conf = new SparkConf().setMaster("local[*]").setAppName("action")
      val sc = new SparkContext(conf)

      // TODO Spark - RDD - 算子 - 行动
      val rdd:RDD[Int] = sc.makeRDD(List(1,2,3,4))

      // TODO reduce：聚合数据
      val i:Int = rdd.reduce(_+_)
      // TODO sum：求和
      val d:Double = rdd.sum()
      // TODO collect：采集
      val as:Array[Int] = rdd.collect()

      println(i)
      println(d)
      println(as)

      sc.stop()
    }
}
