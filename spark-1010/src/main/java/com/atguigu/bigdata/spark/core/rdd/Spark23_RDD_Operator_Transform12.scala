package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark23_RDD_Operator_Transform12 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val numRDD:RDD[Int] = sc.makeRDD(List(1,4,2,3))

    // TODO - Spark - 算子 - 转换 - sortBy
    // 通过指定的规则对集合中的数据进行排序，第二个参数false表示降序，默认为升序
    val sortRDD:RDD[Int] = numRDD.sortBy(num=>num)

    sortRDD.collect().foreach(println)

    sc.stop()
  }
}
