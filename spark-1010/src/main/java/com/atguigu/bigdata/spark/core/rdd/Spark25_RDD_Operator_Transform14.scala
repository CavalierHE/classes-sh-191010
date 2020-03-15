package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}


object Spark25_RDD_Operator_Transform14 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val numRDD1:RDD[(String,Int)] = sc.makeRDD(List(("a",1),("b",2),("c",3),("d",4)),2)

    // TODO - Spark - 算子 - 转换 - KV 类型
    println(
      numRDD1.mapPartitionsWithIndex(
        (index,list)=> {
          list.map( (index, _) )
        }
      ).collect().mkString(",")
    )

    // 功能点扩展
    // trait：动态混入
    // 隐式转换
    // partitionBy在RDD中不存在，但是由于隐式转换规则，可以动态转换为PairRDDFunction类型
    // 然后动态调用其中的partitionBy方法

    // 分区器Partitioner可以决定数据的流向，到底走到哪一个分区
    // Spark框架默认提供了HashPartitioner分区器
    // HashPartitioner实现原理为数据key.hashCode和分区的数量进行取余操作，决定数据存放在哪个分区
    println("***********************************")
    var hashRDD:RDD[(String,Int)] = numRDD1.partitionBy(new HashPartitioner(3))

    println(
      hashRDD.mapPartitionsWithIndex(
        (index,list)=>{
          list.map((index,_))
        }
      ).collect().mkString(",")
    )

    sc.stop()
  }
}
