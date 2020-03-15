package com.atguigu.bigdata.spark.core.partition

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark01_Partition01 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("dep")
    val sc = new SparkContext(conf)

    val lineRDD:RDD[String] = sc.textFile("input/1.txt")
    val wordRDD:RDD[String] = lineRDD.flatMap(line=>{
     line.split(" ")
    })

    val wordToOneRDD:RDD[(String,Int)] = wordRDD.map(word=>(word,1))

    wordToOneRDD.sortByKey(true)

    sc.stop()
  }
}
