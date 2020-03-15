package com.atguigu.bigdata.scala.chapter07

import scala.collection.mutable

object Scala21_Collection_Operator6 {
  def main(args: Array[String]): Unit = {
      // TODO Scala - 集合 - 数据操作方法（函数）
      // 两个Map的合并
      val map1 = mutable.Map(("a",1),("b",2),("c",3))
      val map2 = mutable.Map(("a",4),("d",5),("c",6))

      // Map(("a",5), ("b",2), ("c",9), ("d",5))
      val result = map1.foldLeft(map2)(
        (map, kv) => {
          val k = kv._1
          val v = kv._2

          // map(key) = newValue
          map(k) = map.getOrElse(k, 0) + v

          map
        }
      )
      println(result)

  }
}
















