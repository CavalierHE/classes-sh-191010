package com.atguigu.bigdata.scala.chapter10

object Scala04_Transfor3 {
  def main(args: Array[String]): Unit = {

    // 如果想要遵循OCP的开发原则，但是又不想修改代码，隐式转换是一个好的选择
    // 隐式转换其实就是将类型A变成类型B，实现功能的转换
    implicit def transform(user:User04):UserExt04 = {
      new UserExt04
    }

    val user = new User04
    user.insert()
    user.update()
  }
}

class UserExt04 {
  def update(): Unit = {
    println("update user...")
  }
}

class User04 {
  def insert(): Unit = {
    println("insert user...")
  }
}