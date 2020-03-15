package com.atguigu.bigdata.scala.chapter06

object Scala10_Object_Class_Instance {

  def main(args: Array[String]): Unit = {
    // TODO - Scala - 面向对象 - Class - 实例化
    // 构造方法
    // Scala是完全面向对象的语言
    // Scala是完全函数式编程语言
    // 类其实也是函数
    // 可以在类声明时，类名的后面增加小括号作为参数列表
    // 这个函数称之为类的构造函数
    // 当使用new关键字创建对象的时候，会自动调用构造方法
    val user = new User10("zhangsan")
    println(user.username)

  }

}

class User10(name:String) {
    var username : String = name
}