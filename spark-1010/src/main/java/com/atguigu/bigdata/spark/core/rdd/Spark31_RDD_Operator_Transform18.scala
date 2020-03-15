package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark31_RDD_Operator_Transform18 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    // TODO Spark - RDD - 算子 - 转换 - aggregateByKey
    val numRDD1:RDD[(String,Int)] =
      sc.makeRDD(List(("a", 3), ("a", 2), ("c", 4), ("b", 3), ("c", 6), ("c", 8)),2)

    // 需求：每个分区取相同key的最大值后相加
    // ("a", 3), ("a", 2), ("c", 4)
    // ("b", 3), ("c", 6), ("c", 8)
    // => (a,5), (b,5), (c,13)
    // 分区内，分区间
    // reduceByKey：分区内和分区间的计算逻辑相同
    // aggregateByKey就可以针对于分区内和分区间进行不同的计算
    // aggregateByKey使用函数柯里化，存在多个参数列表
    // 第一个参数列表
    //      zeroValue：分区内的第一条数据进行计算的初始值
    // 第二个参数列表
    //      seqOp：分区内计算规则
    //      combOp：分区间计算规则
//    val aggRDD:RDD[(String,Int)] =
//        numRDD1.aggregateByKey(5)((x,y)=>{math.max(x,y)},(x,y)=>x+y)

    val aggRDD:RDD[(String,Int)] =
      numRDD1.aggregateByKey(10)((x,y)=>x+y,(x,y)=>x+y)
    println(aggRDD.collect().mkString(","))

    sc.stop()
  }
}
