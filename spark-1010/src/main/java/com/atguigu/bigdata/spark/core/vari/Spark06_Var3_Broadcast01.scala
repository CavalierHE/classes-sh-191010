package com.atguigu.bigdata.spark.core.vari

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark06_Var3_Broadcast01 {
  def main(args: Array[String]): Unit = {

    // 广播变量
    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    // 准备数据
    val rdd1 = sc.makeRDD(List( ("a",1), ("b", 2), ("c", 3), ("d", 4) ),4)
    val list = List(("a",4), ("b", 5), ("c", 6), ("d", 7))

    // (a, (1,4)), (b, (2,5)), (c, (3,6)), (d, (4,7))
    // (a, (1,4))
    // ("a",1)
    //TODO 当前的程序中使用list集合会在每一个Task发一份
    //      会导致Executor中存在大量的冗余数据，一旦task过多，或数据过多
    //      那么Executor内存就有可能不够用，会导致OOM
    // 为了解决这样的问题，可以采用分布式共享只读变量：广播变量
    val resultRDD:RDD[(String,(Int,Int))] = rdd1.map {
      case (key,num) => {
        var num2 = 0
        for ((k,v) <- list) {
          if (k == key) {
            num2 = v
          }
        }
        (key,(num,num2))
      }
    }
    println(resultRDD.collect().mkString(","))

    sc.stop()
  }
}
