package com.atguigu.bigdata.scala.chapter05

object Scala10_Function9_TailRecursion {

    def main(args: Array[String]): Unit = {
        // TODO 函数式编程 - 尾递归(循环)
        test("123")
    }
    def test( name:String ): Unit = {
        // 函数在最后的位置调用自身，而且不需要额外的数据处理
        println("name = " + name)
        test(name)
    }
    
}
