package com.atguigu.bigdata.scala.chapter06



object Scala05_Object_Class {

  def main(args: Array[String]): Unit = {

    // TODO - Scala - 面向对象 - Class
    // 1. 如果类名和伴生对象名称相同，称之为伴生类
    //    编译时并不会产生多个类文件
    // 2. 创建对象的时候，可以直接创建
    //val user = new User05()
    //  创建对象时，等同于调用类的构造方法，但是构造方法没有声明参数，
    //  所以构建的时候可以省略小括号。
    //val user = new User05
    // 3. 调用对象中的方法
    //val user = new User05
    //user.test()
    //Scala05_Object_Class.main()
    // 4. 父类
    // 子类可以继承父类，使用extends关键字
    // 5. 多态使用时，不能进行类型推断
    //val user05:User05 = new User05
    //val user05:Person05 = new User05
    val user05 = new User05
  }

}

class Person05{

}

// 声明类
// class 类名 {}
// 伴生类
class Scala05_Object_Class{

}

class User05 extends Person05{
  def test(): Unit = {

  }
}


