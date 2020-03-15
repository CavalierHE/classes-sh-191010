package com.atguigu.bigdata.spark.streaming.wordcount

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object TransWordCount {

  def main(args: Array[String]): Unit = {

    //1.创建SparkConf
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("TransWordCount")

    //2.创建StreamingContext
    val ssc = new StreamingContext(sparkConf, Seconds(5))

    //3.从端口获取数据创建流
    val lineDStream: ReceiverInputDStream[String] = ssc.socketTextStream("hadoop102", 9999)

    println(s"11111*****${Thread.currentThread().getName}")

    //4.使用transform算子进行WordCount统计
    val wordToCountDStream: DStream[(String, Int)] = lineDStream.transform(rdd => {

      println(s"22222*****${Thread.currentThread().getName}")

      val wordRDD: RDD[String] = rdd.flatMap(_.split(" "))
      val wordToOneRDD: RDD[(String, Int)] = wordRDD.map(x=>{
        println(s"33333*****${Thread.currentThread().getName}")
        (x, 1)
      })
      val wordToCountRDD: RDD[(String, Int)] = wordToOneRDD.reduceByKey(_ + _)

      wordToCountRDD
    })

    //5.打印
    wordToCountDStream.print()

    //6.启动任务
    ssc.start()
    ssc.awaitTermination()

  }

}
