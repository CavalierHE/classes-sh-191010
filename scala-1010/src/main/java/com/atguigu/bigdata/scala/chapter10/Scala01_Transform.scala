package com.atguigu.bigdata.scala.chapter10

object Scala01_Transform {
  def main(args: Array[String]): Unit = {
    // TODO Scala - 隐式转换 - 自动转换

    // 如果因为数据类型不匹配，导致程序编译出错
    // 那么可以采用编译器的隐式转换功能，将类型转换后让程序编译通过
    // 可以简单的将这个转换过程称之为二次编译
    // 隐式转换会在编译时，由编译器在指定的范围内自动识别转换规则
    // 所以需要增加特殊的关键字

    // 编译时，编译器会将隐式转换规则（函数）自动应用到程序编译出错的地方
    // 完成类型的转换
    val user = new User01

    // 隐式函数
    implicit def transform(d:Double): Int = {
      d.toInt
    }

    val age : Int = user.age

    println(age)
  }
}

class User01 {
  val age:Double = 20.0
}