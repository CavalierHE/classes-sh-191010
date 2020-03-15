package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark39_RDD_Example_1 {
    def main(args: Array[String]): Unit = {

      // jar -> spark -> 应用App -> 作业

      val conf = new SparkConf().setMaster("local[*]").setAppName("example")
      val sc = new SparkContext(conf)

      // TODO 需求：统计出每一个省份广告被点击次数的Top3
      // 1. 获取用户广告的点击的日志数据
      val lineRDD: RDD[String] = sc.textFile("input/agent.log")

      // 2. 将日志数据转换结构 （x,y,z,a,b） => ( 省份_广告，1 )
      val priAndAdvToOneRDD: RDD[(String, Int)] = lineRDD.map(
        line => {
          val datas: Array[String] = line.split(" ")
          (datas(1) + "_" + datas(4), 1)
        }
      )

      // 3. 将转换结构后的数据进行分组聚合 ( 省份_广告，1 ) => ( 省份_广告，Sum )
      val priAndAdvToSumRDD: RDD[(String, Int)] = priAndAdvToOneRDD.reduceByKey(_+_)

      // 4. 将聚合的结果进行结构的转换 ( 省份_广告，Sum ) => ( 省份, (广告，Sum) )
      val priToAdvAndSumRDD: RDD[(String, (String, Int))] = priAndAdvToSumRDD.map {
        case (key, sum) => {
          val keys: Array[String] = key.split("_")
          (keys(0), (keys(1), sum))
        }
      }

      // 5. 将转换结构后的数据根据省份进行分组
      //    ( 省份, (广告，Sum) ) => ( 省份, Iterator[ (广告，Sum) ] )
      val groupRDD: RDD[(String, Iterable[(String, Int)])] = priToAdvAndSumRDD.groupByKey()

      // 6. 将同一省份中的数据根据广告点击次数进行排序（降序）
      // 7. 将排序后的数据取前三名（Top3）
      val resultRDD: RDD[(String, List[(String, Int)])] = groupRDD.mapValues(
        datas => {
          datas.toList.sortWith(
            (left, right) => {
              left._2 > right._2
            }
          ).take(3)
        }
      )

      // 8. 将结果采集后打印在控制台。
      resultRDD.collect().foreach(println)

      sc.stop()
    }
}
