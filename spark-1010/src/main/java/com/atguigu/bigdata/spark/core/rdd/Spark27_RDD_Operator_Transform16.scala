package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark27_RDD_Operator_Transform16 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val numRDD1:RDD[(String,Int)] = sc.makeRDD(List(("nba",1),("cba",2),("nba",3),("cba",4)),2)

    // TODO - Spark - 算子 - 转换 - KV 类型
    // reduceByKey 可以将相同的key对应的value进行reduce操作
    val wordToCountRDD:RDD[(String,Int)] = numRDD1.reduceByKey(_+_)

    println(wordToCountRDD.collect().mkString(","))

    sc.stop()
  }
}
