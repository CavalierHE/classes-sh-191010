package com.atguigu.bigdata.scala.chapter05

object Scala13_Function12_Lazy {

    def main(args: Array[String]): Unit = {
        // TODO 函数式编程 - 惰性函数（lazy），延迟加载
        lazy val res = sum(10, 30) // List(10000)，占用内存空间很长时间，使用惰性函数处理，被需要时再执行
        println("----------------") // 执行10s的一段逻辑
        println("res=" + res) //处理10000条数据的集合
    }
    def sum(n1: Int, n2: Int): Int = {
        println("sum被执行。。。")
        return n1 + n2
    }
}
