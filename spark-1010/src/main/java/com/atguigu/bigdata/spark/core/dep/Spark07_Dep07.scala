package com.atguigu.bigdata.spark.core.dep

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark07_Dep07 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("dep")

    val sc = new SparkContext(conf)
    sc.setCheckpointDir("cp")

    val lineRDD: RDD[String] = sc.textFile("input/1.txt")

    val wordRDD: RDD[String] = lineRDD.flatMap(line=>{
      println("flatMap......")
      line.split(" ")
    })

    val wordToOneRDD: RDD[(String, Int)] = wordRDD.map(word=>(word, 1))
    // cache方法会在异常情况下导致数据丢失
    // 如果希望数据存储在磁盘中不丢失，可以采用检查点操作
    // 检查点操作时需要指定存储位置

    // 执行行动算子的时候，会执行保存检查点的操作
    // 但是为了保证数据的准确性需要从头再执行一次（job）
    // 所以检查点一般需要和cache联合使用
    wordToOneRDD.cache()
    wordToOneRDD.checkpoint()
    wordToOneRDD.saveAsTextFile("output1")
    println("***************************")
    wordToOneRDD.saveAsTextFile("output2")

    sc.stop()
  }
}
