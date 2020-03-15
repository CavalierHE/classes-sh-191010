package com.atguigu.bigdata.scala.chapter06

object Scala01_Object {

  def main(args: Array[String]): Unit = {

    // TODO - Scala -面向对象

    val user:User01 = new User01()
    println(user.username)
    println(user.login())
  }

}

//声明Scala中的类
class User01 {
  //声明属性(变量)
  var username = "zhangsan"
  //声明方法
  def login() : Boolean = {
    true
  }
}