package com.atguigu.bigdata.scala.chapter07

object Scala12_Collection_Dim {
  def main(args: Array[String]): Unit = {
      // TODO Scala - 集合 - Dim
      val arr = Array.ofDim[Int](3,4)
      arr(1)(2) = 88
      for (i <- arr) { //i 就是一维数组

          for (j <- i) {
            print(j + " ")
          }

          println()
      }
  }
}
