package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Spark42_RDD_Operator_Action3 {
    def main(args: Array[String]): Unit = {

      val conf = new SparkConf().setMaster("local[*]").setAppName("action")
      val sc = new SparkContext(conf)

      // TODO Spark - RDD - 算子 - 行动
      val rdd:RDD[Int] = sc.makeRDD(List(4,3,1,2))

      // TODO count：数量（个数）
      val l:Long = rdd.count()
      println(l)
      // TODO first：第一个数据
      val f:Int = rdd.first()
      println(f)
      // TODO take：取N个数据
      val t1 = rdd.take(3)
      val t2 = rdd.takeOrdered(3)

      println(t1.mkString(","))
      println(t2.mkString(","))

      sc.stop()
    }
}
