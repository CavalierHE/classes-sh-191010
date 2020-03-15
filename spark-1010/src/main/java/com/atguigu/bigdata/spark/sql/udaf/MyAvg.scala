package com.atguigu.bigdata.spark.sql.udaf

import org.apache.spark.sql.Row
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types.{DataType, DoubleType, IntegerType, StructField, StructType}

class MyAvg extends UserDefinedAggregateFunction{

  //定义输入数据类型
  override def inputSchema: StructType = StructType(StructField("input",IntegerType)::Nil)

  //定义中间数据类型
  override def bufferSchema: StructType = StructType(StructField("sum",IntegerType)::StructField("total",IntegerType)::Nil)

  //定义输出数据类型
  override def dataType: DataType = DoubleType

  //函数稳定性
  override def deterministic: Boolean = true

  //给中间缓存赋初始值
  override def initialize(buffer: MutableAggregationBuffer): Unit = {
    buffer(0) = 0
    buffer(1) = 0
  }

  //分区内更新缓存的数据
  override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
    //判断输入数据是否为Null
    if(!input.isNullAt(0)) {
      buffer(0) = buffer.getInt(0) + input.getInt(0)
      buffer(1) = buffer.getInt(1) + 1
    }
  }

  //分区间数据累加
  override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
    buffer1(0) = buffer1.getInt(0) + buffer2.getInt(0)
    buffer1(1) = buffer1.getInt(1) + buffer2.getInt(1)
  }

  //计算最终结果
  override def evaluate(buffer: Row): Double = {
    buffer.getInt(0).toDouble / buffer.getInt(1)
  }
}
