package com.atguigu.bigdata.spark.utils

import java.io.InputStreamReader
import java.util.Properties

//读取KV类型的配置文件
object PropertiesUtil {

  //加载文件
  def load(path:String):Properties = {
    val properties = new Properties
    properties.load(new InputStreamReader(Thread.currentThread().getContextClassLoader.getResourceAsStream(path),"UTF-8"))
    properties
  }
}
