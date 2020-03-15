package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{Partitioner, SparkConf, SparkContext}

object Spark26_RDD_Operator_Transform15 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val numRDD1:RDD[(String,Int)] = sc.makeRDD(List(("nba",1),("cba",2),("nba",3),("cba",4)),2)

    // TODO - Spark - 算子 - 转换 - KV 类型
    println(
      numRDD1.mapPartitionsWithIndex(
        (index,list)=> {
          list.map( (index, _) )
        }
      ).collect().mkString(",")
    )

    // 自定义分区器
    var hashRDD:RDD[(String,Int)] = numRDD1.partitionBy(new MyPartitioner(3))
    println(
      hashRDD.mapPartitionsWithIndex(
        (index,list)=>{
          list.map((index,_))
        }
      ).collect().mkString(",")
    )

    println(hashRDD.getNumPartitions)

    sc.stop()
  }

  // 声明分区器
  // 1.继承Partitioner
  // 2.重写方法numPartitions，getPartition
  class MyPartitioner(i: Int) extends Partitioner {
    override def numPartitions: Int = i

    override def getPartition(key: Any): Int = {
      key match {
        case null => 0
        case s:String if "nba".equals(s) => {
          1
        }
        case s:String if "cba".equals(s) => {
          2
        }
        case _ => 0
      }
    }
  }
}
