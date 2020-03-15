package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark15_RDD_WordCount_1 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    // TODO Spark - WordCount - 1
    // TODO groupby

    val stringRDD:RDD[String] = sc.makeRDD(List("Hello Spark","Hello Spark"))

    val wordRDD:RDD[String] = stringRDD.flatMap(_.split(" "))

    val groupRDD:RDD[(String,Iterable[String])] = wordRDD.groupBy(word=>word)

    //val wordToCountRDD:RDD[(String,Int)] = groupRDD.map(t=>(t._1,t._2.size))

    val wordToCountRDD:RDD[(String,Int)] = groupRDD.mapValues(list=>list.size)

    wordToCountRDD.collect().foreach(println)

    sc.stop()
  }
}
