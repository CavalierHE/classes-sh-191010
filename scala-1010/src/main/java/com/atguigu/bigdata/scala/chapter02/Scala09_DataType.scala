package com.atguigu.bigdata.scala.chapter02

object Scala09_DataType {
    def main(args: Array[String]): Unit = {
    
        // TODO 数据类型
        // 默认的数值类型就是Int类型
        // 如果想要缩小数值的精度，需要指定类型，不能省略
//        val age:Byte = 20
    
        // 默认的浮点数值类型就是Double类型
//        val score:Float = 20.0f
//        println(age)
//
//        println(sc)
        
       // val c : Char = 'A' + 1
        //println(c)
        
        //val i:Int = 10
        // 万物皆对象
        //val b:Byte = i.toByte
        //println(b)
        
        val age : String = "20.5"
        val i : Int = age.toDouble.toInt
        println(i)
    }
}
