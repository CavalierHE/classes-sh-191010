package com.atguigu.bigdata.spark.core.vari

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark05_Var3_Broadcast {
  def main(args: Array[String]): Unit = {

    // 广播变量
    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    // 准备数据
    val rdd1 = sc.makeRDD(List( ("a",1), ("b", 2), ("c", 3), ("d", 4) ),4)
    val rdd2 = sc.makeRDD(List( ("a",4), ("b", 5), ("c", 6), ("d", 7) ),2)

    // Join算子不一定有shuffle操作
    // 当RDD中处理的数据增加时，性能会受到极大的影响
    val joinRDD:RDD[(String,(Int,Int))] = rdd1.join(rdd2)

    println(joinRDD.collect().mkString(","))

    sc.stop()
  }
}
