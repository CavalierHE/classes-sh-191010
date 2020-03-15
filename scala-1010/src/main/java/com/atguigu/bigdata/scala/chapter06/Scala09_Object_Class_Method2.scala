package com.atguigu.bigdata.scala.chapter06

object Scala09_Object_Class_Method2 {

  def main(args: Array[String]): Unit = {
    // TODO - Scala - 面向对象 - Class - 方法 - apply

    // apply方法主要用于构建对象，但是不见得只能构建本类型的对象
    // 如果使用伴生对象，却没有增加小括号，获取的其实是伴生对象(单例对象)本身
    // 如果想要调用apply方法，必须增加小括号
    val user = User09("zhangsan")
    println(user)
  }

}

//构造方法私有化：构造参数列表前增加private关键字
//伴生对象可以访问伴生类中的私有内容
class User09 private() {
  private def this(name:String){
    this()
  }
}

object User09 {
  // apply方法如果没有参数，也要增加小括号
  //def apply() = new java.util.Date()
  //def apply() = new User09()
  def apply(name:String) = new User09(name)
}