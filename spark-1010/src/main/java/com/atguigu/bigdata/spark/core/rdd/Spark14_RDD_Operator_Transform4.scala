package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark14_RDD_Operator_Transform4 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val numRDD:RDD[Int] = sc.makeRDD(List(1,4,2,3),2)

    // TODO - Spark - 算子 - 转换 - groupBy
    // 将数据根据指定的规则进行分组
    // 1 => 1
    // 2 => 0
    // 3 => 1
    // 4 => 0
    //val groupRDD:RDD[(Int,Iterable[Int])] = numRDD.groupBy(num=>num%2)
    val stringRDD:RDD[String] = sc.makeRDD(List("Hello","Spark","Scala","Hadoop"),2)
    val groupRDD:RDD[(String,Iterable[String])] = stringRDD.groupBy(s=>s.substring(0,1))

    groupRDD.collect().foreach(println)

    sc.stop()
  }
}
