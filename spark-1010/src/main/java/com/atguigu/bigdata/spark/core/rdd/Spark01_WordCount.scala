package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark01_WordCount {
  def main(args: Array[String]): Unit = {
    //TODO Spark 第一个案例：WordCount
    //TODO 连接Spark框架（获取Spark环境）
    // 1.创建环境配置对象
    //val conf = new SparkConf()
    //conf.setMaster("local[2]") // 环境
    //conf.setAppName("WordCount") // 应用名称
    val conf = new SparkConf().setMaster("local[2]").setAppName("WordCount")
    //2.创建上下文环境对象
    val sc = new SparkContext(conf)

    // TODO 执行WordCount
    //1.读取文件，IDEA中默认读取的就是项目的目录
    val lineRdd: RDD[String] = sc.textFile("input")

    //2.将每一行字符串进行拆分，拆分成一个一个的单词
    val wordRdd: RDD[String] = lineRdd.flatMap(line => line.split(" "))

    //3. 将单词转换结构 word => ( word, 1 )
    val wordToOneRdd: RDD[(String, Int)] = wordRdd.map(word => (word, 1))

    // 4.1 （Scala）将相同的单词放置在一个组中，完成聚合
    // 4.2  (Spark) 使用reduceByKey进行数据的分组和统计
    //      需要将数据转换特定的结构后才可以调用reduceByKey的方法
    val wordToSumRdd: RDD[(String, Int)] = wordToOneRdd.reduceByKey((x, y) => x + y)

    //5.将结果采集后打印在控制台上，collect采集的意思
    wordToSumRdd.collect().foreach(println)

    //TODO 简化版开发
//    sc.textFile("input")
//        .flatMap(_.split(" "))
//        .map((_,1))
//        .reduceByKey(_+_)
//        .collect()
//        .foreach(println
    //TODO 释放连接
    sc.stop()
  }
}
