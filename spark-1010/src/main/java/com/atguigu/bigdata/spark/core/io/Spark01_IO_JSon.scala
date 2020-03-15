package com.atguigu.bigdata.spark.core.io

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark01_IO_JSon {
  def main(args: Array[String]): Unit = {

    // Json
    // JavaScript Object Notation
    // 特殊标记的JS对象(没有类型)
    // "{ 'username':'zhangsan', 'age':20 }"
    // [{ "username":"lisi", "age":20 }]
    // 将符合JSON格式的对象使用字符串进行声明，在网络中传递，称之为JSON字符串
    val conf = new SparkConf().setMaster("local[*]").setAppName("JSON")
    val sc = new SparkContext(conf)

    // Spark中读取文件采用hadoop的方式进行读取，所以按行读取
    // 所以读取的一行数据应该符合JSON格式，而不是整个文件符合JSON格式
    // Spark读取JSON文件，需要保证每一行符合JSON格式
    val jsonRDD:RDD[String] = sc.textFile("input/user.json")

    import scala.util.parsing.json.JSON
    val resultRDD:RDD[Option[Any]] = jsonRDD.map(JSON.parseFull)

    resultRDD.collect().foreach(println)

    sc.stop()
  }
}
