package com.atguigu.bigdata.scala.chapter02

import java.io.BufferedReader

import scala.io.StdIn

object Scala07_In {
    def main(args: Array[String]): Unit = {
    
        // 标准化输入
        //val line: String = StdIn.readLine
        //println(line)
        
        val age : Int = StdIn.readInt()
        println(age)
        
        //val reader = new BufferedReader()
    }
}
