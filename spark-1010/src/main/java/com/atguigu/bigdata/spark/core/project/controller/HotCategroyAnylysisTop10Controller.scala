package com.atguigu.bigdata.spark.core.project.controller

import java.sql.DriverManager

import com.atguigu.bigdata.spark.core.project.common.TController
import com.atguigu.bigdata.spark.core.project.service.HotCategroyAnylysisTop10Service


/**
  *
  * 热门品类Top10分析控制器
  *
  */

class HotCategroyAnylysisTop10Controller extends TController{

  private val hotCategroyAnylysisTop10Service = new HotCategroyAnylysisTop10Service()

  override def execute(): Unit = {
    //val datas = hotCategroyAnylysisTop10Service.analysis()
    //val datas = hotCategroyAnylysisTop10Service.analysis1()
    //val datas = hotCategroyAnylysisTop10Service.analysis2()
    //val datas = hotCategroyAnylysisTop10Service.analysis3()
    val datas = hotCategroyAnylysisTop10Service.analysis4()
    datas.foreach(println)
    // 一般情况下，需求的结果会被保存到数据库中

    /*
    // Connection
    // PrepareStatement
    // TODO 可以将链接对象提到集合循环之外，减少连接的次数，提高性能
    Class.forName("xxx")
    val conn = DriverManager.getConnection("xxx")
    val pstat = conn.prepareStatement("sql")
    // TODO 如果RDD的foreach算子执行数据库操作，那么将链接对象放置在循环之外会出问题，所有的连接对象都无法序列化
    datas.foreach(
      data => {
        // 执行数据库操作
        // JDBC
        pstat.executeUpdate()
      }
    )
    */

    // TODO 如果RDD的foreach算子执行数据库操作性能低，可以采用另外一个算子实现
    // mapPartitions
//    datas.foreachPartition(
//      datas => {
//        //Class.forName("xxx")
//        //val conn = DriverManager.getConnection("xxx")
//        //val pstat = conn.prepareStatement("sql")
//          datas.foreach(
//            pstat.executeUpdate()
//          )
//      }
//    )

  }

}
