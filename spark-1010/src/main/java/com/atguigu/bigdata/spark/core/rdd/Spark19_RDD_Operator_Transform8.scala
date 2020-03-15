package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark19_RDD_Operator_Transform8 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val numRDD:RDD[Int] = sc.makeRDD(List(1,2,3,4,5,6),2)

    // TODO - Spark - 算子 - 转换 - coalesce
    val filterRDD:RDD[Int] = numRDD.filter(_==1)

    filterRDD.mapPartitionsWithIndex(
      (index,list)=>{
        list.map((index,_))
      }
    ).collect().foreach(println)

    //println(filterRDD.getNumPartitions)

    //合并分区
    val coalesceRDD:RDD[Int] = filterRDD.coalesce(1)

    println(coalesceRDD.getNumPartitions)

    sc.stop()
  }
}
