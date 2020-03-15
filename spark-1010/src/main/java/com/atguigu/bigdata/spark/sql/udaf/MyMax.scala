package com.atguigu.bigdata.spark.sql.udaf

import org.apache.spark.sql.Row
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types._

class MyMax extends UserDefinedAggregateFunction{

  //输入数据类型
  override def inputSchema: StructType = StructType(StructField("input",IntegerType)::Nil)

  //缓存数据类型
  override def bufferSchema: StructType = StructType(StructField("buf",IntegerType)::Nil)

  //输出数据类型
  override def dataType: DataType = IntegerType

  //函数类型
  override def deterministic: Boolean = true

  //初始化
  override def initialize(buffer: MutableAggregationBuffer): Unit = {

  }

  //分区内更新缓冲区数据
  override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {

    //判断是否为第一次比较
    if (buffer.isNullAt(0)) {
      //判断当前输入数据是否为Null
      if (!input.isNullAt(0)) {
        buffer(0) = input.getInt(0)
      }
    } else {
      //判断当前输入数据是否为Null
      if (!input.isNullAt(0)) {
        buffer(0) = Math.max(buffer.getInt(0), input.getInt(0))
      }
    }
  }

  //分区间更新缓冲区数据
  override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {

    if (!buffer1.isNullAt(0)) {
      buffer1(0) = Math.max(buffer1.getInt(0),buffer2.getInt(0))
    } else {
      buffer1(0) = buffer2.getInt(0)
    }

  }

  //计算最终值
  override def evaluate(buffer: Row): Integer = buffer.getInt(0)
}
