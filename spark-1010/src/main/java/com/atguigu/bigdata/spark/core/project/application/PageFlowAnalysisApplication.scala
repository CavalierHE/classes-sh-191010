package com.atguigu.bigdata.spark.core.project.application

import com.atguigu.bigdata.spark.core.project.common.TApplication
import com.atguigu.bigdata.spark.core.project.controller.PageFlowAnalysisController

/**
  * 页面单跳转化率统计
  */

object PageFlowAnalysisApplication extends App with TApplication{

  startOnLocal {
    val controller = new PageFlowAnalysisController
    controller.execute()
  }
}
