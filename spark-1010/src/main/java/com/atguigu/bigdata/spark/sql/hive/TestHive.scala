package com.atguigu.bigdata.spark.sql.hive

import org.apache.spark.sql.SparkSession

object TestHive {

  def main(args: Array[String]): Unit = {

    //1.创建SparkSession
    val spark:SparkSession = SparkSession
      .builder()
      .appName("TestHive")
      .master("local[*]")
      .enableHiveSupport()
      .getOrCreate()

    import spark.implicits._

    //2.创建表
    spark.sql("select count(*) from gmall.ads_uv_count").show()

    //3.关闭资源
    spark.stop()
  }
}
