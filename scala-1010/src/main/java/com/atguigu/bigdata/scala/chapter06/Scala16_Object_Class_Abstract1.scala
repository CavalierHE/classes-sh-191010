package com.atguigu.bigdata.scala.chapter06

object Scala16_Object_Class_Abstract1 {

  def main(args: Array[String]): Unit = {

    // TODO 面向对象 - 抽象

    new ChiildUser16().test()
  }

}

abstract class User16{
  // 抽象类中可以没有抽象方法
  def test():Unit = {

  }
}

class ChiildUser16 extends User16{
  // TODO Scala语言中，如果重写父类的完整的方法，那么子类必须使用override关键字
  // TODO 如果重写父类的不完整的方法，那么子类只需要补充完整即可，但是也可以增加overrid关键字
  // 方法的重写
  override def test(): Unit = {
    println("test...")
  }
}