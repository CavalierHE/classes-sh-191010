package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark38_RDD_Operator_Transform22 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    // TODO Spark - RDD - 算子 - 转换 - join
    val rdd1 = sc.makeRDD(List(("a",1),("b",2),("a",3),("c",4)))
    val rdd2 = sc.makeRDD(List(("a",3),("b",4),("a",5)))

    // sql
    // table1 join table2 on xxxxxx
    // table1.col1 table2.col1
    // join可以将两个不同的RDD中相同key的数据联合在一起
    // 不同的key直接过滤掉
    // join 会产生笛卡尔乘积，相同的key保留，可以存在多个相同的key
    // join 一定会有shuffle，并且会有笛卡尔乘积，性能不够好，不推荐使用

    //val rdd:RDD[(String,(Int,Int))] = rdd1.join(rdd2)

    // TODO Spark - RDD - 算子 - 转换 - cogroup

    // connect + group => cogroup
    val rdd:RDD[(String,(Iterable[Int],Iterable[Int]))] = rdd1.cogroup(rdd2)

    println(rdd.collect().mkString(","))

    sc.stop()
  }
}
