package com.atguigu.bigdata.spark.streaming.wordcount

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.dstream.InputDStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable

object RDDWordCount {

  def main(args: Array[String]): Unit = {

    //1.创建SparkConf
    val sparkConf:SparkConf = new SparkConf().setAppName("SocketWordCount").setMaster("local[*]")

    //2.创建StreamingContext
    val ssc = new StreamingContext(sparkConf,Seconds(3))

    //创建一个可变的RDD队列
    val rddQueue = new mutable.Queue[RDD[Int]]()

    //3.从一个RDD队列中获取数据创建DStream
    val dStream:InputDStream[Int] = ssc.queueStream(rddQueue)

    //4.计算WordCount并打印
    dStream.map((_,1))
      .reduceByKey(_ + _)
      .print()

    //5.开启任务
    ssc.start()

    //6.循环创建并向RDD队列中放入RDD
    for (i <- 1 to 5) {
      rddQueue += ssc.sparkContext.makeRDD(1 to 3)
      Thread.sleep(2000)
    }

    ssc.awaitTermination()
  }
}
