package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark29_RDD_Operator_Transform17 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val numRDD1:RDD[(String,Int)] = sc.makeRDD(List(("nba",1),("cba",2),("nba",3),("cba",4)),2)

    // TODO - Spark - 算子 - 转换 - KV 类型 - groupByKey
    // groupBy可以自定义分组的规则
    // groupByKey只能针对于key进行分组
    // 返回结果类型为：（分组key，多个value的可迭代集合）
    val groupRDD:RDD[(String,Iterable[Int])] = numRDD1.groupByKey()

    //println(groupRDD.getNumPartitions)

    println(groupRDD.mapValues(_.sum).collect().mkString(","))

    sc.stop()
  }
}
