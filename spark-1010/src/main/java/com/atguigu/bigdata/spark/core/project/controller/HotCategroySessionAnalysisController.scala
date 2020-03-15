package com.atguigu.bigdata.spark.core.project.controller

import com.atguigu.bigdata.spark.core.project.common.TController
import com.atguigu.bigdata.spark.core.project.service.HotCategroySessionAnalysisService
import org.apache.spark.rdd.RDD

class HotCategroySessionAnalysisController extends TController{

  private val hotCategroySessionAnalysisService = new HotCategroySessionAnalysisService

  override def execute(): Unit = {
    val datas: Array[(String, List[(String, Int)])] = hotCategroySessionAnalysisService.analysis()
    datas.foreach(println)
    //println(datas.count())
  }
}
