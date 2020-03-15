package com.atguigu.bigdata.scala.chapter06

object Scala21_Object_Class_Trait2 {

  def main(args: Array[String]): Unit = {

    //  TODO 面向对象 - 特质
    println(new User21())
  }
}

trait MyTrait1{

}

trait Mytrait2{

}

class Person21{

}

// TODO 如果一个类已经存在父类，但是依然要混入特质，需要采用关键字with
class User21 extends Person21 with MyTrait1 with Mytrait2 {

}
