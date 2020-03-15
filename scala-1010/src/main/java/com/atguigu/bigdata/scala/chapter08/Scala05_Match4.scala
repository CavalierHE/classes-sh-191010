package com.atguigu.bigdata.scala.chapter08

object Scala05_Match4 {

   def main(args: Array[String]): Unit = {
//       def test() = {
//         ("zhangsan", 20)
//       }
//
//        // TODO 模式匹配可以省略
//       val t = test()
//       val (name, age) = test()
//       println(t._1 + "," + t._2)
//       println(s"name=$name, age=$age")

      // TODO 循环时也可以采用模式匹配
      val list = List( ("a", 1), ("b", 2), ("a", 3) )
//      for ( t <- list ) {
//         if ( t._1.equals("a") ) {
//              println(t._2)
//         }
//      }
//       for ( ( "a", num ) <- list ) {
//       //for ( ( _, num ) <- list ) {
//           println(num)
//       }

        // TODO Map
        val map: Map[String, Int] = Map( ("a", 1), ("b", 2), ("c", 3) )
//
        println(map.mapValues(_ * 2))
//         println(map.map(
//           t => {
//             (t._1, t._2 * 2)
//           }
//         ))
        // 1. map需要传递的函数的参数只有一个，所以此时case关键字不能省略
        // 2. map函数在进行参数的模式匹配时，需要将小括号变成大括号
         val result: Map[String, Int] = map.map {
           case (word, count) => {
             (word, count * 2)
           }
         }
         println(result)


   }

}
