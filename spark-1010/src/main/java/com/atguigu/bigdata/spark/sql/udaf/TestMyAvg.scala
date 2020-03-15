package com.atguigu.bigdata.spark.sql.udaf

import org.apache.spark.sql.{DataFrame, SparkSession}

object TestMyAvg {
  def main(args: Array[String]): Unit = {

    //1.创建SparkSession
    val spark:SparkSession = SparkSession
      .builder()
      .appName("TestMyAvg")
      .master("local[*]")
      .getOrCreate()

    //2.导入隐式转换
    import  spark.implicits._

    //3.注册UDAF函数
    spark.udf.register("myavg",new MyAvg)

    //4.读取JSON文件创建DF
    val df:DataFrame = spark.read.json("input/people.json")

    //5.计算平均年纪
    df.createTempView("f4")
    spark.sql("select myavg(age) from f4").show()

    //6.关闭资源
    spark.stop()
  }
}
