package com.atguigu.bigdata.spark.streaming.wordcount

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}

object WindowWordCount02 {

  def main(args: Array[String]): Unit = {

    //1.创建SparkConf
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("WindowWordCount02")

    //2.创建StreamingContext
    val ssc = new StreamingContext(sparkConf, Seconds(3))
    ssc.checkpoint("./ck1")

    //3.从端口获取数据创建流
    val lineDStream: ReceiverInputDStream[String] = ssc.socketTextStream("hadoop102", 9999)

    //4.将数据转换为KV
    val wordToOneDStream: DStream[(String, Int)] = lineDStream.flatMap(_.split(" ")).map((_, 1))

    //5.计算每个单词出现的次数同时开窗并打印
    //    wordToOneDStream.reduceByKeyAndWindow(_ + _, Seconds(6)).print()
    wordToOneDStream.reduceByKeyAndWindow((x: Int, y: Int) => x + y,
      (a: Int, b: Int) => a - b,
      Seconds(6),
      Seconds(3),
      ssc.sparkContext.defaultParallelism,
      (x: (String, Int)) => x._2 > 0)
      .print()

    //6.开启任务
    ssc.start()
    ssc.awaitTermination()

    ssc.stop(stopSparkContext = true, stopGracefully = true)

  }

}
