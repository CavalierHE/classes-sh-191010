package com.atguigu.bigdata.scala.chapter05

object Scala04_Function3_NightMare {

    def main(args: Array[String]): Unit = {
        
        // TODO 函数式编程 - 噩梦
        // 至简原则：能省则省
        // 如果编译器能够正确的推断语法结构，那么这个语法结构就可以省略
        // TODO 1. 函数调用时，如果没有参数，那么调用的小括号可以省略
        def f1(): Unit = {
            println("f1...")
        }
        f1
        // TODO 2. 如果能推断出类型，那么return关键字可以省略
        //         如果不使用return关键字，那么会将函数体中满足条件的最后一行代码作为返回值
        // val s : String = "zhangsan"
        // val s = "zhangsan"
        def f2(): String = {
            //return "zhangsan"
            "zhangsan"
        }
        println(f2)
        // TODO 3. 如果能推断出类型，那么函数的返回值类型可以省略
//        def f3(): String = {
//             "zhangsan"
//        }
        def f3() = {
            "zhangsan"
        }
        println(f3)
        // TODO 4. 如果函数体中逻辑代码只有一行，那么花括号可以省略
//        def f4() = {
//            "zhangsan"
//        }
        def f4() = "zhangsan"
        println(f4)
        
        // TODO 5. 如果函数的参数没有，那么小括号可以省略
        // 统一访问原则
        val name = "zhangsan"
        def f5 = "lisi"
        println(f5)
        
        // TODO 6. 如果函数就想省略返回值类型Unit，但是又不想自动推断类型，那么可以省略等号
        // 如果函数有参数但是固定没有返回值，我们称之为 过程 函数
        // 6.1 如果函数的返回值类型声明为Unit，那么编译器不会使用最后一行代码作为返回值
        // 6.2 如果函数的返回值类型声明为Unit，那么return关键字不起作用
        // 6.3 如果函数体中使用return关键字，那么返回值类型不能省略
        //def f6(): Unit = {
        def f6():String = {
            // 6.1 "zhangsan"
            // 6.2 return "zhangsan"
            // 6.3 return "zhangsan"
            // 6 "zhangsan"
            return "zhangsan"
        }
        println(f6)
        
        // TODO 7. 匿名函数: (a:Int) => { 函数体 }
        // def 函数名（参数列表）：函数返回值 = { 函数体 }
        // JSON => { "name":"zhangsan" }
        def f7( a:Int, b:Int ) : Int = {
            a + b
        }
        // 声明匿名函数
        // (a:Int) => { println(a) }
        
        // 调用匿名函数
        // 需要将函数(整体)进行赋值给一个变量，然后通过这个变量进行访问。
        // 函数式编程中函数是第一公民
        val f8 = (a:Int) => { println(a) }
        f8(30)
    }
}
