package com.atguigu.bigdata.scala.chapter06

object Scala14_Object_Class_Instance4 {

  def main(args: Array[String]): Unit = {

    val user = new User14()

  }
}
class Person14(name:String) {
  println("1...")
  def this() {
    this("111")
    println("2...")
  }
}
class User14(var name:String) extends Person14{
  println("3...")
  def this() {
    this("222")
    println("4...")
  }
  // 1...
  // 2...
  // 3...
  // 4...

}

