package com.atguigu.bigdata.scala.chapter10

object Scala03_Transform2 {
  def main(args: Array[String]): Unit = {
    // 函数的参数可以设定隐式参数，当数据发生变化时，可以动态进行转换。

    def regUser( implicit password:String = "000000" ): Unit = {
      println("password = " + password)
    }

    // 隐式变量
    implicit var pswd:String = "123123"
    //implicit var name:String = "zhangsan"

    // 注册用户
    // 调用一个函数时，如果函数参数支持隐式转换，那么调用函数可以不声明小括号
    // 会由编译器自动完成隐式变量的查找，自动进行函数的参数调用
    //regUser
    // 如果调用函数时，没有省略小括号，那么会使用参数的默认值
    regUser()

    println(List(1, 3, 2, 5).sortBy(num => num))
  }
}

