package com.atguigu.bigdata.scala.chapter06

object Scala08_Object_Class_Method1 {

  def main(args: Array[String]): Unit = {
    // TODO - Scala - 面向对象 - Class - 方法
    //val user = new User08()

    // 伴生对象可以访问伴生类中私有的属性和方法
    println(User08.instance())
    // Scala通过伴生对象构建类的实例时，可以自动识别特殊的方法apply
    // apply方法的小括号不能省略

    // 如果伴生对象中声明了apply方法，那么调用时即使不使用方法名也可以调用
    println(User08.apply())
    println(User08())
    // apply方法可以重载
    println(User08("zhangsan"))

    // TODO 如果构建对象时，使用new关键字，那么调用的就是对象的构造方法
    // TODO 如果构建对象时，不使用new关键字，那么调用的是伴生对象的apply方法
  }

}

class User08 {

}

object User08 {
  //模拟静态方法
  def instance(): User08 = new User08()
  def apply(): User08 = new User08()
  def apply(name:String): User08 = new User08()
}