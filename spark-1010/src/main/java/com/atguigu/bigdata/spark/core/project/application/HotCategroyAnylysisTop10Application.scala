package com.atguigu.bigdata.spark.core.project.application

import com.atguigu.bigdata.spark.core.project.common.TApplication
import com.atguigu.bigdata.spark.core.project.controller.HotCategroyAnylysisTop10Controller

/**
  * Top10 热门品类的分析
  */
object HotCategroyAnylysisTop10Application extends App with TApplication {

  // 启动应用
  startOnLocal{
    // 分析逻辑（三层架构模式）
    val controller = new  HotCategroyAnylysisTop10Controller()
    controller.execute()
  }
}
