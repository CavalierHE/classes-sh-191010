package com.atguigu.bigdata.scala.chapter06

object Scala17_Object_Class_Abstract2 {

  def main(args: Array[String]): Unit = {
    // TODO 面向对象 - 抽象
    //Scala语言中的属性也可以是抽象的
    //如果一个类中存在抽象属性
    //那么编译器不会给这个类产生属性，只会编译生成2个抽象的
    //方法，一个set，一个get
    //所谓的抽象属性其实还是抽象方法
    //所谓的重写属性其实就是编译生成属性和set，get方法
    println(new ChildUser17().name)
  }

}

//如果一个类中包含了不完整的属性，那么这个类也不完整
//，应该声明为抽象的
abstract class User17 {
  //不完整的属性就是抽象属性
  //不完整的属性只有属性的声明没有属性的初始化
  var name:String
}

class ChildUser17 extends User17 {
  //将父类的属性补充完整
  var name:String = "zhangsan"
}