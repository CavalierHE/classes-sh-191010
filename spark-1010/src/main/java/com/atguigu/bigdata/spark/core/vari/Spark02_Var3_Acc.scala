package com.atguigu.bigdata.spark.core.vari

import org.apache.spark.{SparkConf, SparkContext}

object Spark02_Var3_Acc {
  def main(args: Array[String]): Unit = {

    // TODO 三大核心变量 累加器
    // 累加器：分布式共享只写变量
    //        累加器可以将Driver端的数据传递给Executor
    //        也可以将计算结果返回给Driver端
    //        中间的计算没有shuffle，性能比较高
    // 累加器可以共享数据
    // 不同Executor节点的累加器无法互相访问和获取的
    // 累加器的作用一般进行数据的求和以及数据聚合
    val conf = new SparkConf().setMaster("local[*]").setAppName("wordCount")
    val sc = new SparkContext(conf)

    val rdd = sc.makeRDD(List(1,2,3,4,5))

    // 声明累加器
    var sum = sc.longAccumulator("sum")

    rdd.foreach(
      num => {
        // 使用累加器
        //sum = sum + num
        sum.add(num)
      }
    )

    // 获取累加器的值
    println("sum = " + sum.value)

    sc.stop()
  }
}
