package com.atguigu.bigdata.scala.chapter06

object Scala06_Object_Class_Field {

  def main(args: Array[String]): Unit = {
    // TODO - Scala - 面向对象 - Class - 属性

    // TODO 1. 声明属性，等同于声明类的变量
    // Bean规范
    // 在编译时，会自动给类产生一个私有属性
    // 并且同时提供两个公共的访问这个属性的方法，类似于java中的set,get方法
    // private String name = "zhangsan";
    // public String name() { return this.name; }
    // public void name_$eq(String x$1) { this.name = x$1; }
    //val user = new User06
    // 如果给对象中的属性赋值，那么等同于访问这个属性的set方法
    //user.name = "lisi"
    // 如果获取对象中的属性值，那么等同于访问这个属性的get方法
    //println(user.name)
    //user.age = 20
    // TODO 2. Scala使用注解来生成符合bean规范的类，属性，方法
    //         @BeanProperty
    // 使用注解后，编译器会在编译时，给类的属性生成4个方法，2个set，2个get
    //        val user = new User06
    //        user.setName("xxxx")
    //        user.getName
    //        user.name = "zhangsan"
    //        println(user.name)
    // TODO 3. Scala中声明类的属性，一定要显示的初始化
    // 给类的属性进行默认初始化，可以采用特殊符号 下划线
    // 如果属性采用val声明，那么不能使用下划线进行默认初始化操作

    // TODO 4. 类的属性采用val声明
    // 编译器会将类的属性声明为final
    // 只会给属性生成get方法，而不会生成set方法，所以无法更改属性的值
    //val user = new User06
    //user.age = 30

    // TODO 5. 访问权限
    // Scala中有4种访问权限
    // 5.1  公共的 ：访问权限最多使用的就是公共的，所以Scala无需声明，
    //               默认使用的就是公共的。所以Scala中没有public关键字
    // 5.2  受保护的 protected 只能同类和子类能访问，同包无法访问。
    // 5.3  包访问 : private[包名] 指定包中可以访问
    //               这里的包名可以使用当前包和父包
    // 5.4  私有的 ：private 只能在本类中访问
    //      编译器在编译时，会将属性set,get方法也声明为private，所以无法访问
    val user = new User06
    //user.sex
    //println(user.sex)

  }
}

class User06 {
  // 声明属性
  //@BeanProperty
  //var name : String = _
  //val age : Int = 10

  // 公共的
  //val sex : String = "男"
  // 受保护的访问权限
  //protected val sex : String = "男"
  // 包访问，包私有
  private[atguigu] val sex : String = "男"
  // 私有
  //private val sex : String = "男"
}

class ChildUser06 extends User06 {
  def test(): Unit = {
    println(sex)
  }
}


