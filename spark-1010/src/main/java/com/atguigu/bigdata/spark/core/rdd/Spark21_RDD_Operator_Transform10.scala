package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark21_RDD_Operator_Transform10 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val numRDD:RDD[Int] = sc.makeRDD(List(1,2,3,4,5,6,7,8),3)

    // TODO - Spark - 算子 - 转换 - repartition
    numRDD.mapPartitionsWithIndex(
      (index,list)=>{
        list.map((index,_))
      }
    ).collect().foreach(println)
    println("*****************")

    // 重分区，会采用shuffle进行处理
    // repartition其实就是coalesce的shuffle操作
    numRDD.repartition(2).mapPartitionsWithIndex(
      (index,list)=> {
        list.map((index,_))
      }
    ).collect().foreach(println)

    sc.stop()
  }
}
