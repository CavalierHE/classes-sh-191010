package com.atguigu.bigdata.spark.core.project.helper

import com.atguigu.bigdata.spark.core.project.bean.HotCategroy
import org.apache.spark.util.AccumulatorV2

import scala.collection.mutable

/**
  * 热门品类累加器
  * IN : String (品类， 行为类型)
  * OUT : Map（品类，HotCategroy）
  */
class HotCategroyAccumulator extends AccumulatorV2[(String, String),mutable.Map[String,HotCategroy ]] {

  var map = mutable.Map[String,HotCategroy]()

  override def isZero: Boolean = {
    map.isEmpty
  }

  override def copy(): AccumulatorV2[(String, String), mutable.Map[String, HotCategroy]] = {
    new HotCategroyAccumulator
  }

  override def reset(): Unit = map.clear()

  // 向累加器中传值
  // click, order, pay
  override def add(v: (String, String)): Unit = {
    val hotCategroy = map.getOrElse(v._1, HotCategroy(v._1, 0,0,0))
    v._2 match {
      case "click" => hotCategroy.clickCount += 1
      case "order" => hotCategroy.orderCount += 1
      case "pay" => hotCategroy.payCount += 1
      case _ =>
    }
    map( v._1 ) = hotCategroy
  }

  override def merge(other: AccumulatorV2[(String, String), mutable.Map[String, HotCategroy]]): Unit = {

      other.value.foreach{
        case ( cid, hotCategroy ) => {
          val hc = map.getOrElse(cid, HotCategroy( cid, 0, 0, 0 ))
          hc.clickCount = hc.clickCount + hotCategroy.clickCount
          hc.orderCount = hc.orderCount + hotCategroy.orderCount
          hc.payCount = hc.payCount + hotCategroy.payCount

          map(cid) = hc
        }
      }
  }

  // 返回累加器的值
  override def value: mutable.Map[String, HotCategroy] = map
}
