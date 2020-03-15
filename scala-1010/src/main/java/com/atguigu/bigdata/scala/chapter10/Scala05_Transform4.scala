package com.atguigu.bigdata.scala.chapter10

object Scala05_Transform4 {
  def main(args: Array[String]): Unit = {

    // Scala语言在新版本中可以直接声明隐式类，直接将A类变成B类
    val user = new User05()
    user.insertUser()
    user.updateUser()
  }

  // 声明隐式类
  // 1.在类声明前增加implicit关键字
  // 2.隐式类应该有主构造方法，而且有一个参数用于转换类型
  implicit class UserExt05(user:User05) {
    def updateUser():Unit = {
      println("update user...")
    }
  }
  class User05 {
    def insertUser():Unit = {
      println("insert user...")
    }
  }

}

