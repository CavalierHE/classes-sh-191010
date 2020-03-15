package com.atguigu.bigdata.spark.sql.writer

import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession}

object Writer {

  def main(args: Array[String]): Unit = {

    //1.创建SparkSession
    val spark: SparkSession = SparkSession.builder()
      .appName("Writer")
      .master("local[*]")
      .getOrCreate()
    import spark.implicits._

    //2.读取数据创建DF
    val df: DataFrame = spark.read.json("input/people.json")

    //3.将DF写出
    //a.通过write方法直接指定写出的文件格式
    df.write.mode(SaveMode.Overwrite).json("out1/json1")
    //    df.write.jdbc()
    //b.通过format指定保存的文件格式
    df.write.format("json").mode(SaveMode.Append).save("out1/json2")
    //    df.write.format("jdbc").option("","").save()

    //4.关闭资源
    spark.stop()

  }
}
