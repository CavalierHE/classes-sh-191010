package com.atguigu.bigdata.spark.sql.test

import org.apache.spark.sql.{DataFrame, SparkSession}

object Test {
  def main(args: Array[String]): Unit = {

    // 创建SparkSession对象
    val spark: SparkSession = SparkSession
      .builder()
      .master("local[*]")
      .appName("Test")
      .getOrCreate()

    // 导入隐式转换
    import spark.implicits._

    // 读取本地文件，创建DataFrame
    val df:DataFrame = spark.read.json("./input/people.json")

    // 打印
    df.show()

    // 创建临时表
    df.createOrReplaceTempView("people")
    // SQL风格：查询年龄在20岁以上的
    spark.sql("SELECT * FROM people where age > 20").show()

    // DSL风格：查询年龄在20岁以上的
    df.select("age").show()
    df.filter($"age" > 20).show()

    // 将DF转换为RDD并打印
    df.rdd.foreach(println)

    // 关闭连接
    spark.stop()
  }
}
