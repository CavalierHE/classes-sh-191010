package com.atguigu.bigdata.scala.chapter06

package object xxx {
  val username : String = "zhangsan"
  def test() : Unit = {
    println("package...")
  }
}

package xxx {
  class User03 {

  }
  package yyy {
    object Scala03_Object_Package1 {

      def main(args: Array[String]): Unit = {

        // TODO - Scala -面向对象 - Package
        // TODO 1.路径没有限制
        // Scala编译器会在编译时自动生成文件路径
        // TODO 2.package关键字可以多次声明
        //      当前类编译后会在最后package所在的包中生成编译类
        // TODO 3.package可以使用层次结构
        //        在package后增加大括号，形成层次结构，有了
        // 自己的作用域范围，子包中的程序可以直接访问父包
        // 中的类，而无需导入操作
        // TODO 4.包也是对象，在package中无法直接声明属性或方法
        //        在包对象中可以声明属性或方法
        //        包对象中的属性或方法在本包或子包可以直接访问
        println(new User03())
        println("package...")
        test()
      }

    }
  }
}




