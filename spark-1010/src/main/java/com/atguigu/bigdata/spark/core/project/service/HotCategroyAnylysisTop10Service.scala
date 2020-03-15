package com.atguigu.bigdata.spark.core.project.service

import com.atguigu.bigdata.spark.core.project.bean.HotCategroy
import com.atguigu.bigdata.spark.core.project.dao.HotCategroyAnylysisTop10Dao
import com.atguigu.bigdata.spark.core.project.helper.HotCategroyAccumulator
import com.atguigu.bigdata.spark.core.project.util.ProjectUtil
import org.apache.spark.rdd.RDD

import scala.collection.mutable

/**
  *
  * 热门品类Top10逻辑服务对象
  */

class HotCategroyAnylysisTop10Service {

  private val hotCategroyAnylysisTop10Dao = new HotCategroyAnylysisTop10Dao()

  //使用累加器实现数据的聚合
  def analysis4() = {
    //TODO 1.获取用户行为的日志数据
    val actionRDD: RDD[String] = hotCategroyAnylysisTop10Dao.textFile

    //TODO 2.声明累加器并注册
    val acc = new HotCategroyAccumulator
    ProjectUtil.getSparkContext().register(acc)

    //TODO 3.将日志数据循环遍历
    actionRDD.foreach(
      action => {
        // 对用户行为类型进行判断
        val datas = action.split("_")
        if (datas(6) != "-1") {
          //点击的场合
          acc.add((datas(6),"click"))
        } else if (datas(8) != "null") {
          //下单的场合
          val ids = datas(8).split(",")
          ids.foreach(
            id => acc.add((id,"order"))
          )
        } else if (datas(10) != "null") {
          //支付的场合
          val ids = datas(10).split(",")
          ids.foreach(
            id => acc.add((id,"pay"))
          )
        }
        else {
          Nil
        }
      })

    //TODO 4.获取累加器的值
    val accValue: mutable.Map[String, HotCategroy] = acc.value
    val hotCategroyMap: mutable.Iterable[HotCategroy] = accValue.map(_._2)
    hotCategroyMap.toList.sortWith(
      (left,right) => {
        if (left.clickCount > right.clickCount) {
          true
        } else if (left.clickCount == right.clickCount) {
          if (left.orderCount > right.orderCount) {
            true
          } else if (left.orderCount == right.orderCount) {
            left.payCount > right.payCount
          }
          else {
            false
          }
        }
        else {
          false
        }
      }
    ).take(10)
  }



  def analysis3() = {
    //TODO 1.获取用户行为的日志数据
    val actionRDD: RDD[String] = hotCategroyAnylysisTop10Dao.textFile

    //TODO 2.将日志数据进行结构的转换
    val mapRDD: RDD[(String,HotCategroy)] = actionRDD.flatMap(
      action => {
        // 对用户行为类型进行判断
        val datas = action.split("_")
        if (datas(6) != "-1") {
          //点击的场合
          List((datas(6),HotCategroy(datas(6), 1, 0, 0)))
        } else if (datas(8) != "null") {
          //下单的场合
          val ids = datas(8).split(",")
          ids.map(
            id => (id,HotCategroy(id,0,1,0))
          )
        } else if (datas(10) != "null") {
          //支付的场合
          val ids = datas(10).split(",")
          ids.map(
            id => (id,HotCategroy(id,0,0,1))
          )
        }
        else {
          Nil
        }
      })

    val reduceRDD: RDD[(String, HotCategroy)] = mapRDD.reduceByKey(
      (c1, c2) => {
        c1.clickCount = c1.clickCount + c2.clickCount
        c1.orderCount = c1.orderCount + c2.orderCount
        c1.payCount = c1.payCount + c2.payCount
        c1
      }
    )

    reduceRDD.sortBy(t=>(t._2.clickCount,t._2.orderCount,t._2.payCount),false).take(10)

  }


  def analysis2() = {
    //TODO 1.获取用户行为的日志数据
    val actionRDD: RDD[String] = hotCategroyAnylysisTop10Dao.textFile

    //TODO 2.将日志数据进行结构的转换
    val mapRDD: RDD[HotCategroy] = actionRDD.flatMap(
      action => {
        // 对用户行为类型进行判断
        val datas = action.split("_")
        if (datas(6) != "-1") {
          //点击的场合
          List(HotCategroy(datas(6), 1, 0, 0))
        } else if (datas(8) != "null") {
          //下单的场合
          val ids = datas(8).split(",")
          ids.map(
            id => HotCategroy(id,0,1,0)
          )
        } else if (datas(10) != "null") {
          //支付的场合
          val ids = datas(10).split(",")
          ids.map(
            id => HotCategroy(id,0,0,1)
          )
        }
        else {
          Nil
        }
      })

    // 将相同的品类分组在一起
    // (String,[(Int,Int,Int),(Int,Int,Int),(Int,Int,Int)])
    val groupRDD: RDD[(String, Iterable[HotCategroy])] = mapRDD.groupBy(_.id)

//    val reduceRDD: RDD[(String, HotCategroy)] = groupRDD.mapValues(
//      list => {
//        list.reduce(
//          (c1, c2) => {
//            c1.clickCount = c1.clickCount + c2.clickCount
//            c1.orderCount = c1.orderCount + c2.orderCount
//            c1.payCount = c1.payCount + c2.payCount
//            c1
//          }
//        )
//      }
//    )
    val reduceRDD: RDD[HotCategroy] = groupRDD.map {
      case (id, list) => {
        list.reduce(
          (c1, c2) => {
            c1.clickCount = c1.clickCount + c2.clickCount
            c1.orderCount = c1.orderCount + c2.orderCount
            c1.payCount = c1.payCount + c2.payCount
            c1
          }
        )
      }
    }

    //reduceRDD.sortBy(d => (d.clickCount,d.orderCount,d.payCount),false)

    //自定义排序(降序)
    reduceRDD.collect().sortWith(
      (left,right) => {
          if (left.clickCount > right.clickCount) {
            true
          } else if (left.clickCount == right.clickCount) {
            if (left.orderCount > right.orderCount) {
              true
            } else if (left.orderCount == right.orderCount) {
              left.payCount > right.payCount
            }
            else {
              false
            }
          }
          else {
            false
          }
      }
    ).take(10)
  }


  // 数据分析
  def analysis1() = {

    //TODO 1.获取用户行为的日志数据
    val actionRDD: RDD[String] = hotCategroyAnylysisTop10Dao.textFile

    // 减少shuffle的次数，提高性能
    //TODO 2.将日志数据进行结构的转换
    // String => (String,(Int,Int,Int))
    val mapRDD: RDD[(String, (Int, Int, Int))] = actionRDD.flatMap(
      action => {
        // 对用户行为类型进行判断
        val datas = action.split("_")
        if (datas(6) != "-1") {
          //点击的场合
          List((datas(6), (1, 0, 0)))
        } else if (datas(8) != "null") {
          //下单的场合
          val ids = datas(8).split(",")
          ids.map((_, (0, 1, 0)))
        } else if (datas(10) != "null") {
          //支付的场合
          val ids = datas(10).split(",")
          ids.map((_, (0, 0, 1)))
        }
        else {
          Nil
        }
      })

    val reduceRDD: RDD[(String, (Int, Int, Int))] = mapRDD.reduceByKey(
      (t1, t2) => {
        (t1._1 + t2._1, t1._2 + t2._2, t1._3 + t2._3)
      })

    // sortBy默认是升序的，需要降序排列
    reduceRDD.sortBy(_._2,false).take(10)


  }

  // 数据分析
  def analysis() = {

    //TODO 1.获取用户行为的日志数据
    val actionRDD: RDD[String] = hotCategroyAnylysisTop10Dao.textFile

    actionRDD.cache()

    //TODO 2.1统计品类的点击数量(品类1,sum)
    val clickRDD: RDD[(String, Int)] = actionRDD.map(
      action => {
        val datas = action.split("_")
        (datas(6), 1)
      }
    ).filter(_._1 != "-1")

    val categroyIdToClickRDD = clickRDD.reduceByKey(_+_)

    //将点击的数据结构进行转换
    //(品类1,sum) => (品类1,(sum,0,0))
    val categroyIdClickRDD = categroyIdToClickRDD.map{
      case (cid,sum) => {
        (cid,(sum,0,0))
      }
    }

    //TODO 2.2统计品类的下单数量(品类1,sum)
    //(品类1,品类2,品类3,1)
    val orderRDD: RDD[String] = actionRDD.map(
      action => {
        val datas = action.split("_")
        datas(8)
      }
    ).filter(_ != "null")
    //将下单的数据进行分解：(品类1,1)
    val orderToOneRDD: RDD[(String, Int)] = orderRDD.flatMap {
      orders => {
        val datas = orders.split(",")
        datas.map((_, 1))
      }
    }

    //将下单的品类数据进行分组聚合：(品类1,1) => (品类1,sum)
    val categroyIdToOrderRDD: RDD[(String, Int)] = orderToOneRDD.reduceByKey(_+_)

    //将下单的数据结构进行转换
    //(品类1,sum) => (品类1,(0,sum,0))
    val categroyIdOrderRDD = categroyIdToOrderRDD.map{
      case (cid,sum) => {
        (cid,(0,sum,0))
      }
    }

    //TODO 2.3统计品类的支付数量(品类1,sum)
    //(品类1,支付数量),(品类2,支付数量),(品类3,支付数量)
    val payRDD: RDD[String] = actionRDD.map(
      action => {
        val datas = action.split("_")
        datas(10)
      }
    ).filter(_ != "null")
    //将支付的数据进行分解：(品类1,1)
    val payToOneRDD: RDD[(String, Int)] = payRDD.flatMap {
      pays => {
        val datas = pays.split(",")
        datas.map((_, 1))
      }
    }

    //将支付的品类数据进行分组聚合：(品类1,1) => (品类1,sum)
    val categroyIdToPayRDD: RDD[(String, Int)] = payToOneRDD.reduceByKey(_+_)

    //将支付的数据结构进行转换
    //(品类1,sum) => (品类1,(0,0,sum))
    val categroyIdPayRDD = categroyIdToPayRDD.map{
      case (cid,sum) => {
        (cid,(0,0,sum))
      }
    }

    //TODO 3.相同品类的统计数据聚集在一起
    //(品类1,点击数量)
    //(品类1,下单数量)
    //(品类1,支付数量)

    //(品类1,点击数量,0,0)
    //(品类1,0,下单数量,0)
    //(品类1,0,0,支付数量)

    //(品类1,(点击数量sum,下单数量sum,支付数量sum))
    val unionRDD: RDD[(String, (Int, Int, Int))] = categroyIdClickRDD.union(categroyIdOrderRDD).union(categroyIdPayRDD)

    val reduceRDD = unionRDD.reduceByKey(
      (t1,t2) => {
        (t1._1 + t2._1,t1._2 + t2._2, t1._3 + t2._3)
      })

    //TODO 将聚集后的结果数据进行排序(降序)
    //TODO 将排序后的结果取前十名
    //Tuple类型的数据可以自动排序，先根据第一个数据排序，然后再根据第二个数据排序，依此类推
    val result: Array[(String, (Int, Int, Int))] = reduceRDD.sortBy(_._2,false).take(10)

    result
  }

}
