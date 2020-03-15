package com.atguigu.bigdata.spark.core.project.common

import com.atguigu.bigdata.spark.core.project.util.ProjectUtil
import org.apache.spark.rdd.RDD

trait TDao {
  def textFile(implicit path:String): RDD[String] = {
    ProjectUtil.getSparkContext().textFile(path)
  }
}
