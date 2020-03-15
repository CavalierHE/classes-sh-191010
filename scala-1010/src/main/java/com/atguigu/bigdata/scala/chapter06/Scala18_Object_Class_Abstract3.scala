package com.atguigu.bigdata.scala.chapter06

object Scala18_Object_Class_Abstract3 {

  def main(args: Array[String]): Unit = {
    // TODO 面向对象 - 抽象
    // 如果一个抽象类中含有完整的属性
    // 那么子类中如果存在相同的属性，必须使用override关键字
    // 称之为属性的重写

    // 属性的重写是不能对可变(var)的属性进行重写
    // 可以对不可变(val)的变量进行重写
    println(new ChildUser18().name)
  }
}


abstract class User18 {
  val name:String = "zhangsan"

//  def test():Unit = {
//    name = "wangwu" // 调用属性的set方法
//    println(name)   //调用属性的get方法
//  }
}

class ChildUser18 extends User18{
  override val name:String = "lisi"
}
