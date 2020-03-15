package com.atguigu.bigdata.spark.streaming.wordcount

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}

object WindowWordCount01 {

  def main(args: Array[String]): Unit = {

    //1.创建SparkConf
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("WindowWordCount01")

    //2.创建StreamingContext
    val ssc = new StreamingContext(sparkConf, Seconds(3))

    //3.从端口获取数据创建流
    val lineDStream: ReceiverInputDStream[String] = ssc.socketTextStream("hadoop102", 9999)

    //4.开窗,设置窗口大小为3倍批次大小,滑动步长等于批次大小
    val windowDStream: DStream[String] = lineDStream.window(Seconds(9), Seconds(6))

    //5.计算WordCount并打印
    windowDStream.flatMap(_.split(" "))
      .map((_, 1))
      .reduceByKey(_ + _)
      .print()

    //6.启动任务
    ssc.start()
    ssc.awaitTermination()

  }

}
