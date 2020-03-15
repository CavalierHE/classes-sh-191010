package com.atguigu.bigdata.spark.streaming.wordcount


import com.atguigu.bigdata.spark.streaming.receiver.CustomerReceiver
import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

object ReceiverWordCount {

  def main(args: Array[String]): Unit = {

    //1.创建SparkConf
    val sparkConf: SparkConf = new SparkConf().setAppName("ReceiverWordCount").setMaster("local[*]")

    //2.创建StreamingContext
    val ssc = new StreamingContext(sparkConf, Seconds(3))

    //3.使用自定义数据源接收数据创建DStream
    val dStream: ReceiverInputDStream[String] = ssc.receiverStream(new CustomerReceiver("hadoop102", 9999))

    //4.计算WordCount并打印
    dStream.flatMap(_.split(" "))
      .map((_, 1))
      .reduceByKey(_ + _)
      .print()

    //5.启动任务
    ssc.start()
    ssc.awaitTermination()

  }

}
