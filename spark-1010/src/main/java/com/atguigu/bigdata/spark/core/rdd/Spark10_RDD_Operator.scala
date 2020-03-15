package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark10_RDD_Operator {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    // TODO 1. RDD中的方法一般称之为算子，有别于对象的方法
    // 这里的算子根据功能分为两大类：
    // TODO 1.1 Transformation：转换
    // old RDD => 算子 => new RDD
    // 1.1.1 根据数据类型也分为两大类
    //      1.1.1.1 单值类型：1,2,"abc"
    //      1.1.1.2 KV类型：("a",1),("b",2)
    //              reduceByKey
    // TODO 1.2 Action：行动
    // 触发RDD的执行
    // collect,saveAsTextFile

    sc.stop()
  }
}
