package com.atguigu.bigdata.scala.chapter11

object Scala03_Generic2 {
  def main(args: Array[String]): Unit = {

    def test( implicit name : String): Unit = {
      println(name)
    }

    //implicit val name : String = "zhangsan"

    // 如果函数有隐式参数，那么调用时不加括号，可以自动应用隐式转换
    // 如果调用时增加括号，那么隐式转换是不起作用，就是一个普通的方式调用

    // 动态获取隐式值
    //val username = implicitly[String]

    //test(username)

    val ints:List[Int] = List(1,2,3,4)
    //"1234"

//    ints.reduce(
//      (a:Int,b:Int) => {
//        a + b
//      }
//    )
//
//    ints.fold("")(_+_)

  }

}


