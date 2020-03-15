package com.atguigu.bigdata.spark.core.vari

import org.apache.spark.{SparkConf, SparkContext}

object Spark01_Var3 {
  def main(args: Array[String]): Unit = {

    // TODO 三大核心变量 累加器
    val conf = new SparkConf().setMaster("local[*]").setAppName("wordCount")
    val sc = new SparkContext(conf)

    val rdd = sc.makeRDD(List(1,2,3,4,5))
    //rdd.sum()
    //rdd.reduce(_+_)
    var sum = 0;

    // RDD没有提供任何的方法从每一个Executor端将计算结果返回到Driver端
    // Spark可以将数据从Driver端传递到Executor端，因为闭包
    // 程序逻辑并没有告诉Spark中间计算结果需要返回，所以Spark不提供这样的功能
    // 所以如果想要解决Executor端返回Driver端数据，可以采用分布式只写变量
    // 累加器
    rdd.foreach(
      num => {
        //println("num = " + num)
        sum = sum + num
      }
    )

    println("sum = " + sum)

    sc.stop()
  }
}
