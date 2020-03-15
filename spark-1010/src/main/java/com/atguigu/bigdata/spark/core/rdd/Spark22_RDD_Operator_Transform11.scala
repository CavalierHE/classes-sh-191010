package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark22_RDD_Operator_Transform11 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val numRDD:RDD[Int] = sc.makeRDD(List(1,2,3,4,5,6,7,8),2)

    // TODO - Spark - 算子 - 转换
    numRDD.mapPartitionsWithIndex(
      (index,list)=>{
        list.map((index,_))
      }
    ).collect().foreach(println)
    println("*****************")

    // coalesce用于改变分区，一般用于将多分区改变成少分区，所以一般称之为合并分区
    // 如果想要将少分区改变为多分区，那么必须使用shuffle功能

    // 多分区 => 少分区
    //    1. 不打散数据：coalesce
    //    2. 打散数据：repartition
    // 少分区 => 多分区：repartition
    println(numRDD.repartition(4).getNumPartitions)
    numRDD.repartition(4).mapPartitionsWithIndex(
      (index,list)=> {
        list.map((index,_))
      }
    ).collect().foreach(println)

    sc.stop()
  }
}
