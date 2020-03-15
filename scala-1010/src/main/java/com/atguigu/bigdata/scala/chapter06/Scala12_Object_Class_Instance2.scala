package com.atguigu.bigdata.scala.chapter06

object Scala12_Object_Class_Instance2 {

  def main(args: Array[String]): Unit = {
    // TODO - Scala - 面向对象 - Class - 实例化
    // 构造方法为什么要传参数？
    // 通过参数给类的属性赋值完成初始化操作
    // 如果Scala声明构造方法时，想要将构造参数传值给属性
    // 可以通过特殊的操作简化这个过程
    // 将参数使用var或val声明，然后省略属性
    // 编译器会将这个参数作为类的属性来生成
    val user = new User12("zhangsan")
    println(user.name)
  }

}

class User12(var name:String) {

}

