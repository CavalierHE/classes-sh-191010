package com.atguigu.bigdata.scala.chapter05

object Scala05_Function4_Hell {

    def main(args: Array[String]): Unit = {
        
        // TODO 函数式编程 - 地狱版
        // TODO 1. 函数可以赋值给变量，变量就是一个函数
        def f1(): Unit = {
            println("test123")
        }
        
        // 将一个函数(整体)赋值给一个变量，那么这个变量就是函数
        // 可以使用下划线将函数作为整体使用
        val v1 = f1 _

//        v1()
        // 如果指定变量的类型为函数，那么下划线是可以不用使用的。
        // TODO 函数作为类型如何声明：(参数类型)=>返回值类型
        val v2:()=>Unit = f1
        
        // 可以使用变量来调用这个函数
        v2()
    
        def f11(a:Int): Int = {
            a + 10
        }
        
        val v11 = f11 _
        val v12:(Int)=>Int = f11
    
        println(v11(10))
        println(v12(10))

        // TODO 2. 函数可以作为参数传递给另外一个函数
        // 2.1 将函数作为参数传递到某一个函数中
        //     需要指定函数的类型
//        def f2( f:(Int)=>Int ): Unit = {
//            // 2.2 调用传递的这个函数
//            println(f(20))
//        }
//        def f22(a:Int): Int = {
//            a + 100
//        }
//        // 调用函数
//        f2( f22 )
        // 使用匿名函数作为参数传递给另外一个函数
        //f2( ( a:Int ) => { a + 200 } )
        // 因为参数的类型已经指明为Int类型，所以参数类型可以省略
        //f2( ( a ) => { a + 200 } )
        // 如果匿名函数中，参数只有一个，那么小括号可以省略
        //f2( a => { a + 200 } )
        // 如果匿名函数中，函数体只有一行代码，那么大括号可以省略
        //f2( a => a + 200 )
        // 如果匿名函数中，参数在函数体中只使用了一次，那么参数可以省略
        // Scala语言采用下划线来代替省略的参数
        //f2( _ + 300 )
        
        def f2( f:(Int, Int)=>Int ): Unit = {
            println(f(10, 10))
        }
        def f22(a:Int, b:Int) = {
            a + b
        }

        def f222(a:Int, b:Int, f:(Int, Int)=>Int ): Unit = {
            println(f(a, b))
        }
        
//        f2( f22 )
//        f2( (a:Int, b:Int) => {a + b} )
//        f2( (a, b) => {a + b} )
//        f2( (a, b) => a + b )
//        f2( _ * _ )
//        def f222(a:Int,b:Int) = {
//            a+b
//        }
    
        f222(40, 20, _/_)
        
        // TODO 3. 函数可以作为返回值返回
//        def f3(): Unit = {
//            println("f3......")
//        }
//
//        def f33() = {
//            f3 _
//        }
//        // 调用函数
//        val v3 = f33()
//        v3()
//        f33()()
        // TODO 嵌套函数：函数中有函数
//        def f3() = {
//            def f33(): Unit = {
//                println("f33.....")
//            }
//            f33 _
//        }

//      f3()()

        def f3(a:Int) = {
           def f33() = {
               a + 10;
           }
            f33 _
        }

        // TODO 闭包：一个函数和它所在的闭合的环境统称为闭包
        // 闭包效果可以将外部的变量移植到当前的环境中，用于进行逻辑操作。
        println(f3(20)())

    }
}
