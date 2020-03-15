package com.atguigu.bigdata.scala.chapter06

object Scala15_Object_Class_Abstract {

  def main(args: Array[String]): Unit = {

    // TODO 面向对象 - 抽象
    // 抽象类，抽象方法
    // 不完整的类就是抽象类
    // 不完整的方法就是抽象方法

    // 抽象类没有办法直接构建对象
    // 可以采用子类继承的方式创建对象

//    new User15
    new ChiildUser15().test()
  }

}

abstract class User15{
  // 只有声明，没有实现的方法就是不完整的，就是抽象的
  def test():Unit
}

class ChiildUser15 extends User15{
  // 如果将不完整的方法补充完整，那么类就不是抽象的
  override def test(): Unit = {
    println("test...")
  }
}