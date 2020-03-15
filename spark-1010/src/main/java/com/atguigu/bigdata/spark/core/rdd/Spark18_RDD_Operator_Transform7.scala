package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark18_RDD_Operator_Transform7 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val numRDD:RDD[Int] = sc.makeRDD(1 to 10)

    // TODO - Spark - 算子 - 转换 - sample
    // 抽取数据 ： 从指定数据集中抽取部分数据
    // 抽奖 ： 抽奖箱
    // 抽取完成后数据是否放回到抽奖箱中
    // 1. 抽取不放回（不重复）：false
    // 2. 抽取放回（重复）: true
    // 1，2，3，4，5，6，7，8，9，10
    // 0.1, 0.2, 0.6, 0.7

    // fraction：表示每一条数据抽取的几率，类似于抛硬币
    // seed：随机数种子
    //val sampleRDD:RDD[Int] = numRDD.sample(false,0.3,8)

    // fraction：表示每一条数据可能抽取的次数

    val sampleRDD:RDD[Int] = numRDD.sample(true,3)

    sampleRDD.collect().foreach(println)

    sc.stop()
  }
}
