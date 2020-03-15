package com.atguigu.bigdata.scala.chapter06

object Scala22_Object_Class_Trait3 {

  def main(args: Array[String]): Unit = {

    //  TODO 面向对象 - 特质

    //  OCP开发原则
    //  特质可以在不改变功能的前提下，动态扩展功能
    //  with：混入
    //  动态混入
    val user = new User22() with MyTrait22
    user.insert()
    user.update()
  }
}

trait MyTrait22 {
  def update():Unit = {
    println("update user...")
  }
}

class Person22 {

}

class User22 extends Person22 {
    def insert():Unit = {
        println("insert user...")
    }

//    def update():Unit = {
//        println("update user...")
//    }
}
