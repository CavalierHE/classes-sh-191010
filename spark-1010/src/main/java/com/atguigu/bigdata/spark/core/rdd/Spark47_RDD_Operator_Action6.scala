package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark47_RDD_Operator_Action6 {
    def main(args: Array[String]): Unit = {

      val conf = new SparkConf().setMaster("local[*]").setAppName("action")
      val sc = new SparkContext(conf)

      val rdd:RDD[Int] = sc.makeRDD(List(1,2,3,4))
      // TODO 保存文本文件
      rdd.saveAsTextFile("output1")

      // TODO KV类型数据可以保存序列文件
      rdd.map((_,1)).saveAsSequenceFile("output2")

      // TODO 保存对象文件
      rdd.saveAsObjectFile("output3")

      sc.stop()
    }
}
