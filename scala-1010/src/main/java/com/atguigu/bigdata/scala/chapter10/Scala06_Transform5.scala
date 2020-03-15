package com.atguigu.bigdata.scala.chapter10

import com.atguigu.bigdata.scala.chapter10.Scala06_Transform5.User06

object Scala06_Transform5 extends Test{

//  implicit class UserExt06(user:User06) {
//    def updateUser():Unit = {
//      println("update user...")
//    }
//  }

  def main(args: Array[String]): Unit = {
    // Scala语言在新版本中可以直接声明隐式类，直接将A类变成B类

    val user = new User06()
    user.insertUser()
    // 隐式转换的作用域在当前类的范围内可以的
    // 隐式转换的作用域在当前包的对象中可以的
    // 隐式转换的作用域在当前类的关联对象中可以的
    user.updateUser()
  }

  class User06 {
    def insertUser():Unit = {
      println("insert user...")
    }
  }
}



// TODO 隐式关键字不能使用在顶级(top-Level)对象当中
//implicit class UserExt06( user:User06 ) {
//  def updateUser(): Unit = {
//    println("update user....")
//  }
//}

trait Test {

}

object Test {
  implicit class UserExt06(user:User06) {
    def updateUser():Unit = {
      println("update user...")
    }
  }
}