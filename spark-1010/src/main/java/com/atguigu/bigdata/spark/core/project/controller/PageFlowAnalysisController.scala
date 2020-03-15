package com.atguigu.bigdata.spark.core.project.controller

import com.atguigu.bigdata.spark.core.project.common.TController
import com.atguigu.bigdata.spark.core.project.service.PageFlowAnalysisService

class PageFlowAnalysisController extends TController{

  private val pageFlowAnalysisService = new PageFlowAnalysisService

  override def execute(): Unit = {
    val datas: Unit = pageFlowAnalysisService.analysis1()
    println(datas)
  }
}
