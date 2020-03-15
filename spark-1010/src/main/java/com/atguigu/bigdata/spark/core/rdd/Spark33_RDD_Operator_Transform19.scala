package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark33_RDD_Operator_Transform19 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    // TODO Spark - RDD - 算子 - 转换 - aggregateByKey
    val numRDD1:RDD[(String,Int)] =
      sc.makeRDD(List(("a", 3), ("a", 2), ("c", 4), ("b", 3), ("c", 6), ("c", 8)),2)

    // aggregateByKey就可以针对于分区内和分区间进行不同的计算
    // aggregateByKey使用函数柯里化，存在多个参数列表：
    // 第一个参数列表
    //      zeroValue：分区内的第一条数据进行计算的初始值
    // 第二个参数列表
    //      seqOp：分区内计算规则
    //      combOp：分区间计算规则

    // reduceByKey是没有初始值概念的
    // 所以aggregateByKey当分区内和分区间计算规则相同时，也不能直接
    // 采用reduceByKey来替换
    // Spark中可以采用新的算子foldByKey来替换和简化

    // scala reduce => reduce(_+_)
    // scala fold => fold(0)(_+_)

//    val rdd:RDD[(String,Int)] =
//      numRDD1.aggregateByKey(0)((x,y)=>x+y,(x,y)=>x+y)
//    println(rdd.collect().mkString(","))

    val rdd: RDD[(String, Int)] = numRDD1.foldByKey(0)(_+_)

    println(rdd.collect().mkString(","))

    sc.stop()
  }
}
