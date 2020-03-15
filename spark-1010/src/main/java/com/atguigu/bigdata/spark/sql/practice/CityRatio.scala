package com.atguigu.bigdata.spark.sql.practice

import java.text.DecimalFormat

case class CityRatio(cityName: String, ratio: Double) {

  private val format = new DecimalFormat("0.0%")

  //北京21.2%
  override def toString: String = {
    s"$cityName:${format.format(ratio)}"
  }
}
