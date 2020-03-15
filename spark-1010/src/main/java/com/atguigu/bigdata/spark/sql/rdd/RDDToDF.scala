package com.atguigu.bigdata.spark.sql.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

object RDDToDF {
  def main(args: Array[String]): Unit = {

    //1.创建SparkSession
    val spark:SparkSession = SparkSession.builder()
      .master("local[*]")
      .appName("RDDToDF")
      .getOrCreate()

    //2.导入隐式
    import spark.implicits._

    //3.创建RDD并转换为RDD[Row]
    val rdd:RDD[String] = spark.sparkContext.textFile("./input/people.txt")
    val rowRDD:RDD[Row] = rdd.map{ line =>
      val para:Array[String] = line.split(",")
      Row(para(0),para(1).toInt)
    }

    //4.创建结构信息
    val structType = StructType(StructField("name",StringType)::
        StructField("age",IntegerType)::Nil)

    //5.根据RDD以及结构信息创建DF
    val df: DataFrame = spark.createDataFrame(rowRDD,structType)

    //6.打印
    df.show()

    //7.关闭连接
    spark.stop()
  }
}
