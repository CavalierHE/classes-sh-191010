package com.atguigu.bigdata.scala.chapter06

object Scala23_Object_Class_Trait4 {

  def main(args: Array[String]): Unit = {

    //  TODO 面向对象 - 特质

    //  Java接口和Scala特质的关系
    //  TODO 所有java中的接口在Scala中都作为特质使用，可以混入
    new User23()
  }
}

// TODO 类，父类，特质，初始化顺序为：父类 -> 特质1 -> 特质2 -> 类
trait MyTrait23 {
    println("1...")
}

trait MyTrait231 {
  println("2...")
}

class Person23 {
    println("3...")
}

class User23 extends Person23 with MyTrait23 with MyTrait231 {
    println("4...")
}

//class User23 extends Person23 with java.io.Serializable {
//
//}
