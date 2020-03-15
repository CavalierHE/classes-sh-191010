package com.atguigu.bigdata.scala.chapter02


object Scala08_Unit {
    def main(args: Array[String]): Unit = {
    
        // TODO Unit
        def test():Unit = {

        }
        val t = test()

        println(t)
        
        // TODO Null(类型) ， null(对象)
        val name = null
        println(name)
        
        val age:Int = 10
        println(age)
        
        // TODO Nothing
        val nil: List[Nothing] = Nil
    }

    def test(): Nothing = {
        throw new Exception
    }
}
