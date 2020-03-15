package com.atguigu.bigdata.spark.sql.writer

import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession}

object JdbcWriter {

  def main(args: Array[String]): Unit = {

    //1.创建SparkSession
    val spark: SparkSession = SparkSession.builder()
      .appName("JdbcWriter")
      .master("local[*]")
      .getOrCreate()
    import spark.implicits._

    //2.读取数据创建DF
    val df: DataFrame = spark.read.json("input/people.json")

    //3.将DF数据写入MySQL
    df.write.format("jdbc")
      .option("url", "jdbc:mysql://hadoop102:3306/gmall")
      .option("dbtable", "people")
      .option("user", "root")
      .option("password", "123456")
      .mode(SaveMode.Overwrite)
      .save()

    //4.关闭连接
    spark.stop()
  }
}
