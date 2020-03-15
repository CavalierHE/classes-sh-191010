package com.atguigu.bigdata.scala.chapter08

object Scala09_Match8 {
    def main(args: Array[String]): Unit = {
        // TODO Scala - 模式匹配
        // 偏函数 ：以偏概全
        // 对集合中满足条件的一部分数据进行处理的函数称之为偏函数
        // 偏函数利用模式匹配进行处理的函数
        // 如何使用偏函数
        // 在函数中使用case语句实现的函数

        // 将该List(1,2,3,4,5,6,"test")中的Int类型的元素加一，并去掉字符串
        val list:List[Any] = List(1,2,3,4,5,6,"test")

        // TODO 实现方式一
        // 数据加一
//        val maplist: List[Any] = list.map(
//            (data: Any) => {
//                data match {
//                    case i: Int => i + 1
//                    case other => other
//                }
//            }
//        )
//
//        // 去掉字符串
//        val filterlist: List[Any] = maplist.filter(_.isInstanceOf[Int])
//
//        println(filterlist)

        // TODO 实现方式二
//        println(
//            list
//               .filter(_.isInstanceOf[Int])
//               .map(_.asInstanceOf[Int] + 1))

        // TODO 实现方式三
        // collect支持偏函数
        list.collect{case i:Int=>i+1}.foreach(println)
        // map不支持偏函数，map是一个全量函数
        //list.map{case i:Int=>i+1}.foreach(println)
    }
}