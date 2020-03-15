package com.atguigu.bigdata.scala.chapter08

import com.atguigu.bigdata.scala.chapter08.User07

object Scala08_Match7 {
    def main(args: Array[String]): Unit = {
        // TODO Scala - 模式匹配
        val (x, y) = (1, 2)
        println(s"x=$x,y=$y")

        val Array(first, second, _*) = Array(1, 7, 2, 9)
        println(s"first=$first,second=$second")

        val User07(name, age) = User07("zhangsan", 16)
        println(s"name=$name,age=$age")
    }
}