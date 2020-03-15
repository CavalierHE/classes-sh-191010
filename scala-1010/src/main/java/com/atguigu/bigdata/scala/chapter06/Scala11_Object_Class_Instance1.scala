package com.atguigu.bigdata.scala.chapter06

object Scala11_Object_Class_Instance1 {

  def main(args: Array[String]): Unit = {
    // TODO - Scala - 面向对象 - Class - 实例化

    // 构造方法想要有多个怎么办？
    // TODO Scala中类的构造方法分为2大类
    //   主构造方法：类名后增加参数列表，称之为主构造方法
    //     主构造方法会完成类的初始化
    //   辅助构造方法：采用特殊名称(this)的方法定义的构造方法称之为辅助构造方法
    //     辅助构造方法只是功能的补充，所以必须直接或间接调用主构造方法完成类的初始化
    //     辅助构造方法在间接调用时，调用的其他构造方法必须已经声明过
    val user = new User11("zhangsan")
    println(user.username)

    println(new User11(20).username)

  }

}

class User11(name:String) {
  // 构造方法体 & 类的主体
  var username : String = name

  def this() = {
    this("lisi")
  }

  def this(age:Int) = {
    this()
  }

}