package com.atguigu.bigdata.scala.chapter06

object Scala24_Object_Class_Trait5 {

  def main(args: Array[String]): Unit = {

    //  TODO 面向对象 - 特质

    //  Java接口和Scala特质的关系
    //  TODO 所有java中的接口在Scala中都作为特质使用，可以混入

    new User24()
  }
}

// TODO 类，父类，特质，初始化顺序为：父类 -> 特质1 -> 特质2 -> 类
trait MyTrait24 {
    println("1...")
}

trait MyTrait241 extends MyTrait24 {
    println("2...")
}

class Person24 extends MyTrait24 {
    println("3...")
}

class User24 extends Person24 with MyTrait241 {
    println("4...")
}
