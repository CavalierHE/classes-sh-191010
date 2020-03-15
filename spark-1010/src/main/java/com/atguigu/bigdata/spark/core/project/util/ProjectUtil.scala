package com.atguigu.bigdata.spark.core.project.util

import org.apache.spark.{SparkConf, SparkContext}

object ProjectUtil {
  // ThreadLocal可以在线程的共享内存中共享数据
  private val scLocal : ThreadLocal[SparkContext] = new ThreadLocal[SparkContext]()

  /**
    * 获取Spark环境对象
    * @return
    */
  def getSparkContext() = {
    // 从内存中获取Spark环境对象
    var sc = scLocal.get()
    if ( sc == null ) {
      val conf = new SparkConf().setMaster("local[*]").setAppName("Application")
      sc = new SparkContext(conf)
      // 将新创建的上下文环境对象保存到内存中
      scLocal.set(sc)
    }
    sc
  }

  def stop(): Unit = {
    getSparkContext().stop()
    // 从线程的内存中删除数据
    scLocal.remove()
  }
}

