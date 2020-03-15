package com.atguigu.bigdata.scala.chapter09

import scala.util.control.Breaks

object Scala02_Exception1 {
  def main(args: Array[String]): Unit = {
    Breaks.break()
  }

  // Scala中抛出异常为什么返回值为Nothing，因为要完全面向对象
  // 异常的返回也要有类型
  //@throws(classOf[Exception])
  def test() = {
    throw new Exception
  }
}
