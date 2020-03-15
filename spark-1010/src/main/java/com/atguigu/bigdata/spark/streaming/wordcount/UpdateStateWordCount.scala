package com.atguigu.bigdata.spark.streaming.wordcount


import com.atguigu.bigdata.spark.streaming.receiver.CustomerReceiver
import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}

object UpdateStateWordCount {

  def main(args: Array[String]): Unit = {

    //1.创建SparkConf
    val sparkConf: SparkConf = new SparkConf().setAppName("UpdateStateWordCount").setMaster("local[*]")

    //2.创建StreamingContext
    val ssc = new StreamingContext(sparkConf, Seconds(3))
    ssc.checkpoint("./ck")

    //3.使用自定义数据源接收数据创建DStream
    val dStream: ReceiverInputDStream[String] = ssc.receiverStream(new CustomerReceiver("hadoop102", 9999))

    //4.将流中的数据转换为(单词,1)
    val wordToOneDStream: DStream[(String, Int)] = dStream.flatMap(_.split(" ")).map((_, 1))

    //5.使用updateStateByKey进行跨批次WordCount计算
    val updateStateFunc: (Seq[Int], Option[Int]) => Some[Int] = (seq: Seq[Int], state: Option[Int]) => {
      //当前批次计算
      val sum: Int = seq.sum
      //取出上一次计算结果
      val lastSum: Int = state.getOrElse(0)
      //新的状态
      Some(sum + lastSum)
    }
    val wordToCountDStream: DStream[(String, Int)] = wordToOneDStream.updateStateByKey(updateStateFunc)

    //6.打印
    wordToCountDStream.print()

    //7.启动任务
    ssc.start()
    ssc.awaitTermination()

  }

}
