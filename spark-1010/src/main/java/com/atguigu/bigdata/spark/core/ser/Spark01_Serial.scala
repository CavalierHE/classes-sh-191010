package com.atguigu.bigdata.spark.core.ser

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Spark01_Serial {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("Serial")
    val sc = new SparkContext(conf)

    val rdd: RDD[String] = sc.makeRDD(Array("hello world", "hello spark", "hive", "atguigu"))

    //println(rdd.filter(line => line.contains("hello")).collect().mkString(","))

    // TODO 在进行逻辑封装的时候，推荐使用样例类封装
    val search = new Search("hello")
    //println(search.getMatch1(rdd).collect().mkString(","))
    println(search.getMatch2(rdd).collect().mkString(","))

    sc.stop()
  }

  // 搜索对象
  case class Search(query:String) {

    def isMatch(s: String): Boolean = {
      s.contains(query)
    }

    // 函数序列化案例
    def getMatch1 (rdd: RDD[String]): RDD[String] = {
      rdd.filter(isMatch)
    }

    // 属性序列化案例
    def getMatch2(rdd: RDD[String]): RDD[String] = {
      val s = query
      //s为字符串对象，本身就可以序列化
      rdd.filter(x => x.contains(s))
    }
  }

}

