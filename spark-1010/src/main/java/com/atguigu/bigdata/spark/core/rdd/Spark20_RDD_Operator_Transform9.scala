package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark20_RDD_Operator_Transform9 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val numRDD:RDD[Int] = sc.makeRDD(List(1,2,3,4,5,6,7,8),3)

    // TODO - Spark - 算子 - 转换 - coalesce
    // 合并分区：默认的合并分区会导致数据不均衡，有可能导致数据倾斜
    numRDD.mapPartitionsWithIndex(
      (index,list)=>{
        list.map((index,_))
      }
    ).collect().foreach(println)
    println("*****************")
    // 可以在合并数据时，将数据打散后均匀分配
    // 合并分去时，如果不采用shuffle，那么数据的分区不会打乱
    // 合并分区时，如果采用shuffle，那么数据的分区会打乱，将数据重新组合

    // coalesce的第二个参数表示是否进行shuffle处理
    numRDD.coalesce(2,true).mapPartitionsWithIndex(
      (index,list)=> {
        list.map((index,_))
      }
    ).collect().foreach(println)

    sc.stop()
  }
}
