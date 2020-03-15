package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark35_RDD_Operator_Transform20 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    // TODO Spark - RDD - 算子 - 转换 - combineByKey
    val numRDD1:RDD[(String,Int)] =
      sc.makeRDD(List(("a", 88), ("b", 95), ("a", 91),
        ("b", 93), ("a", 95), ("b", 98)),2)

    // 需求：计算相同key的数据的平均值
    //        平均值 = 总和(88,91,95) / 个数(3)
    // ("a", 88), ("b", 95), ("a", 91)
    // (a, (88,1)) => (a, (88+91,1+1)) => (a, (179,2))
    // ("b", 93), ("a", 95), ("b", 98)  =>  (a, (95,1))
    // (a, (274, 3))
    //numRDD1.reduceByKey(_+_)
    //numRDD1.groupByKey()
    //numRDD1.aggregateByKey(0)(_+_, _+_)
    //numRDD1.foldByKey(0)(_+_)
    //  分区内进行第一次计算前，应该将数据的结构发生改变
    //  88 => (88,1) + 91

    //  combineByKey算子的参数3个
    //    createCombiner：用于将初始值进行转换的函数
    //    mergeValue：分区内计算规则
    //    mergeCombiners：分区间计算规则
    println(numRDD1.combineByKey(
      num => (num,1), // 转换数据的结构
      (t:(Int,Int),num) => { // 分区内计算规则
        (t._1 + num, t._2 + 1)
      },
      (t1:(Int,Int),t2:(Int,Int)) => { // 分区间计算规则
        (t1._1 + t2._1, t1._2 + t2._2)
      }
    ).mapValues(
      (t) => {
        t._1 / t._2
      }
    ).collect().mkString(","))

    sc.stop()
  }
}
