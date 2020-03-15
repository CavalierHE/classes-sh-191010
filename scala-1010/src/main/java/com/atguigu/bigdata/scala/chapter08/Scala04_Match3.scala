package com.atguigu.bigdata.scala.chapter08

object Scala04_Match3 {

  def main(args: Array[String]): Unit = {
    // Scala - 模式匹配
    // 所谓的模式匹配，其实就在匹配规则

    // TODO 匹配类型
    // 模式匹配在匹配类型时，不考虑泛型
   def describe(x: Any) = {
       x match {
           case i: Int => "Int"
           case s: String => "String hello"
           //case m: List[_] => "List"
           case m: List[Int] => "List"
           case c: Array[Int] => "Array[Int]"
           case someThing => "something else " + someThing
       }
   }

    // Array[Int] => int[]
    // List[Int]  => List<Integer>
    //println(describe(Array("1","2")))

    // TODO 匹配数组
    //Object[] obj = new Object[2]
//   val array: Array[Any] = Array(10, "abc", true)
//         for (arr <- Array(
//              Array(0),
//              Array(1, 0),
//              Array(0, 1, 0),
//              Array(1, 1, 0),
//              Array(1, 1, 0, 1),
//              Array("hello", 90))) { // 对一个数组集合进行遍历
//
//             val result = arr match {
//             case Array(0) => "0" //匹配Array(0) 这个数组
//             case Array(x, y) => x + "," + y //匹配有两个元素的数组，然后将将元素值赋给对应的x,y
//             case Array(0, _*) => "以0开头的数组" //匹配以0开头和数组
//             case _ => "something else"
//             }
//
//             println("result = " + result)
//         }

    // TODO 匹配列表
//     for (list <- Array(
//          List(0),
//          List(1, 0),
//          List(0, 0, 0),
//          List(1, 0, 0),
//          List(88))) {
//
//         val result = list match {
//           case List(0) => "0" //匹配List(0)
//           case List(x, y) => x + "," + y //匹配有两个元素的List
//           case List(0, _*) => "0 ..."
//           case _ => "something else"
//         }
//         println(result)
//     }

//     val list: List[Int] = List(1, 2, 5, 6, 7)
//
//     list match {
//       case first :: second :: rest => println(first + "-" + second + "-" + rest)
//       case _ => println("something else")
//     }

    // TODO 匹配元祖
    //对一个元祖集合进行遍历
    for(tuple <- Array((0,1),(1,0),(1,1),(1,0,2))) {
      val result = tuple match {
        case (0,_) => "0 ..." //是第一个元素是0的元祖
        case (y,0) => "" + y + "0" //匹配后一个元素是0的对偶元祖
        case (a, b) => "" + a + " " + b
        case _ => "something else" //默认
      }
      println(result)
    }
  }
}
