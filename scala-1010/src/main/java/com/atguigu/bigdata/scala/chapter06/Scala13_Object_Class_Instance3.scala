package com.atguigu.bigdata.scala.chapter06

object Scala13_Object_Class_Instance3 {

  def main(args: Array[String]): Unit = {
    // TODO - Scala - 面向对象 - Class - 实例化
    // 如果父类存在有参的构造方法，那么子类必须显示的调用父类的构造方法
    val user = new User13("lisi")
  }

}

class Person13(name:String) {
  println("person13...")
}

class User13(var name:String) extends Person13(name){
  println("user13...")
}

