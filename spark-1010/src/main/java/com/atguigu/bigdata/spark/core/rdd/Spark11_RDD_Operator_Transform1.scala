package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark11_RDD_Operator_Transform1 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val numRDD:RDD[Int] = sc.makeRDD(List(1,2,3,4),2)

    // TODO - Spark - 算子 - 转换 - map
    // 将集合中的数据转换成其他的数据
    // A => B
    // def getPartitions: Array[Partition] = firstParent[T].partitions
    // map算子执行后，分区和之前的RDD的分区保持一致
    //val num2RDD:RDD[Int] = numRDD.map(num=> num*2)

    // TODO - Spark - 算子 - 转换 - mapPartitions
    // mapPartitions是以分区为单位进行计算，那么计算性能可以得到提高
    //val map2RDD:RDD[Int] = numRDD.mapPartitions(list=>list.map(_*2))

    // TODO - Spark - 算子 - 转换 - mapPartitions
    val map3RDD:RDD[Int] = numRDD.mapPartitionsWithIndex(
      (pindex,list) => {
        if(pindex == 1) {
          list.map(_ * 2)
        } else {
          list
        }
      }
    )

//    numRDD.mapPartitionsWithIndex(
//      (index,list) => {
//        list.map(num => (index,num))
//      }
//    ).collect().foreach(println)

    //num2RDD.saveAsTextFile("output")

    map3RDD.collect().foreach(println)

    sc.stop()
  }
}
