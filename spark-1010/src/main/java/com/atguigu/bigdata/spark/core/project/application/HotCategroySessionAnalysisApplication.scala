package com.atguigu.bigdata.spark.core.project.application

import com.atguigu.bigdata.spark.core.project.common.TApplication
import com.atguigu.bigdata.spark.core.project.controller.HotCategroySessionAnalysisController

/**
  * Top10热门品类中每个品类的Top10活跃Session统计
  */

object HotCategroySessionAnalysisApplication extends App with TApplication{

  startOnLocal {
    val controller = new HotCategroySessionAnalysisController
    controller.execute()
  }
}
