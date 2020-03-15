package com.atguigu.bigdata.scala.chapter02

object Scala03_Var1 {
    def main(args: Array[String]): Unit = {
        
        // TODO 变量 & 常量
        // var|val 变量名称：类型 = 变量值
        // 如果编译器能够自动推断出变量的取值类型，那么可以省略变量类型
        // Scala至简原则：能省则省
        //val name:String = "zhangsan"
        //val name = "zhangsan"
        //val age:Int = 20
        
        //val age = 20
        
        // Scala语言中分号可以省略的。因为可以把一行代码作为一个完整的逻辑
        // 如果一行中存在多个逻辑的场合，那么分号是不能省略的。
        val name = "zhangsan"; val age = 20
        
    }
}
