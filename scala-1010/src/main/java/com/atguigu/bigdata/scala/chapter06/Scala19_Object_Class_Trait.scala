package com.atguigu.bigdata.scala.chapter06

object Scala19_Object_Class_Trait {

  def main(args: Array[String]): Unit = {

    //  TODO 面向对象 - 特质
    //  特质类似于java中接口
    //  将多个对象中相同的特征从对象中剥离出来，形成特殊的结构，称之为特质(Trait)
    //  如果一个类，对象符合这个特征，那么就可以将这个特质混入到对象(类)中

    new Person19().run()
  }
}

// 声明特质
// 编译器在编译时，会自动生成接口
// 如果一个类使用extends混入特质，编译时依然为实现接口
trait Operator {
  // 跑 - 抽象方法
  // 特质中可以声明抽象方法
  def run():Unit
}

// 人应该具有跑的特征，应该混入特质
// 可以使用extends来进行混入
class Person19 extends Operator{
  def run(): Unit = {
      println("person run...")
  }
}

