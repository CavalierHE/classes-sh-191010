package com.atguigu.bigdata.scala.chapter06

object Scala20_Object_Class_Trait1 {

  def main(args: Array[String]): Unit = {

    //  TODO 面向对象 - 特质
    new Person20().test()
  }
}

// TODO 特质不仅仅可以理解为接口，也可以理解为抽象类
// TODO 特质在某些情况下可以理解为抽象类，所以类可以extends特质
// TODO 特质也可以继承其他的类
class User20{
  def test():Unit = {
    println("test...")
  }
}


trait Operator20 extends User20{
  def run():Unit

  // 特质可以声明完整的方法
  override def test():Unit = {
      println("oper test...")
  }
}

class Person20 extends Operator20{
  def run(): Unit = {
      println("person run...")
  }

  override def test(): Unit = {
      println("Person20...")
  }
}

