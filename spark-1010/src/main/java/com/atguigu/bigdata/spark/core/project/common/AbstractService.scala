package com.atguigu.bigdata.spark.core.project.common

import com.atguigu.bigdata.spark.core.project.bean.UserVisitAction
import org.apache.spark.rdd.RDD
import com.atguigu.bigdata.spark.core.project.service._

abstract class AbstractService {

  def getDao():TDao

  def getUserVisitActions() = {
    // TODO 加载用户行为数据
    val dataRDD: RDD[String] = getDao.textFile

    // 为了操作方便，将原始日志数据转化为样例类对象
    val actionRDD:RDD[UserVisitAction] = dataRDD.map(
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
    actionRDD

  }

}
