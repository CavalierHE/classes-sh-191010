package com.atguigu.bigdata.spark.core.project.service

import com.atguigu.bigdata.spark.core.project.bean.{HotCategroy, UserVisitAction}
import com.atguigu.bigdata.spark.core.project.dao.HotCategroySessionAnalysisDao
import com.atguigu.bigdata.spark.core.project.helper.HotCategroyAccumulator
import com.atguigu.bigdata.spark.core.project.util.ProjectUtil
import org.apache.spark.broadcast.Broadcast
import org.apache.spark.rdd.RDD

import scala.collection.mutable
import scala.util.control.Breaks._

class HotCategroySessionAnalysisService {

  val hotCategroySessionAnalysisDao = new HotCategroySessionAnalysisDao

  def analysis() = {

    //TODO 读取文件
    val rdd: RDD[String] = hotCategroySessionAnalysisDao.textFile
    // 为了操作方便，将原始日志数据转化为样例类对象
    val actionRDD:RDD[UserVisitAction] = rdd.map(
      action => {
        val datas = action.split("_")
        UserVisitAction(
          datas(0),
          datas(1).toLong,
          datas(2),
          datas(3).toLong,
          datas(4),
          datas(5),
          datas(6).toLong,
          datas(7).toLong,
          datas(8),
          datas(9),
          datas(10),
          datas(11),
          datas(12).toLong
        )
      }
    )

    // TODO Top10热门品类
    val acc = new HotCategroyAccumulator
    ProjectUtil.getSparkContext().register(acc)

    rdd.foreach(
      action => {
        // 对用户行为类型进行判断
        val datas = action.split("_")
        if (datas(6) != "-1") {
          // 点击的场合
          acc.add(( datas(6), "click" ))
        } else if (datas(8) != "null") {
          // 下单的场合
          val ids = datas(8).split(",")
          ids.foreach(
            id => acc.add((id, "order"))
          )
        } else if (datas(10) != "null") {
          // 支付的场合
          val ids = datas(10).split(",")
          ids.foreach(
            id => acc.add((id, "pay"))
          )
        } else {
          Nil
        }
      }
    )

    val accValue: mutable.Map[String, HotCategroy] = acc.value
    val hotCategroyMap = accValue.map(_._2)

    val categroys: List[HotCategroy] = hotCategroyMap.toList.sortWith(
      (left, right) => {
        if (left.clickCount > right.clickCount) {
          true
        } else if (left.clickCount == right.clickCount) {
          if (left.orderCount > right.orderCount) {
            true
          } else if (left.orderCount == right.orderCount) {
            left.payCount > right.payCount
          } else {
            false
          }
        } else {
          false
        }
      }
    ).take(10)

   // 将原始数据进行数据的转换:(品类_session,count)
    val categroyIdAndSessionIdToOneRDD: RDD[(String, Int)] = actionRDD.flatMap(
      action => {
        action match {
          case a: UserVisitAction if a.click_category_id != -1 =>
            List((a.click_category_id + "_" + a.session_id, 1))
          case a: UserVisitAction if a.order_category_ids != "null" =>
            val ids = a.order_category_ids.split(",")
            ids.map(id => (id + "_" + a.session_id, 1))
          case a: UserVisitAction if a.pay_category_ids != "null" =>
            val ids = a.pay_category_ids.split(",")
            ids.map(id => (id + "_" + a.session_id, 1))
          case _ => Nil
        }
      })


    // 将转换结构后的数据进行筛选过滤
    // TODO filter算子
    // categroys声明在Driver，使用在Executor
    val ids: List[String] = categroys.map(_.id)
    // 使用广播变量提高性能
    val broadcastIds: Broadcast[List[String]] = ProjectUtil.getSparkContext().broadcast(ids)
    val filterRDD: RDD[(String, Int)] = categroyIdAndSessionIdToOneRDD.filter {
      case (key, one) => {
        val ks = key.split("_")
        val cid = ks(0) // 品类ID
        broadcastIds.value.contains(cid)
//        var flg = false
//        // 判断品类ID是否存在于前10中
//        breakable {
//          for (c <- categroys) {
//            if (c.id == cid) {
//              flg = true
//              break
//            }
//          }
//        }
//        flg
      }
    }

    //TODO 将过滤后的数据进行分组聚合
    // (品类_session,1) => (品类_session,sum)
    val categroyAndSessionToSumRDD:RDD[(String,Int)] = filterRDD.reduceByKey(_+_)

    //TODO 将聚合后的结果进行结构的转换
    // (品类_session,sum) => (品类,(session,sum))
    val categroyToSessionAndSumRDD: RDD[(String, (String, Int))] = categroyAndSessionToSumRDD.map {
      case (key, sum) => {
        val ks: Array[String] = key.split("_")
        (ks(0), (ks(1), sum))
      }
    }

    //TODO 将转换结构后的数据按照key进行分组
    // (品类,(session,sum)) => (品类,Iterable[(session,sum)])
    val groupRDD: RDD[(String, Iterable[(String, Int)])] = categroyToSessionAndSumRDD.groupByKey()

    //TODO 分组后，对每个组中的session的点击数量进行排序取前10名
    val resultRDD: RDD[(String, List[(String, Int)])] = groupRDD.mapValues(
      datas => {
        datas.toList.sortWith(
          (left, right) => left._2 > right._2
        ).take(10)
      }
    )
    resultRDD.collect()

  }
}
