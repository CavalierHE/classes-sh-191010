package com.atguigu.bigdata.scala.chapter05

object Scala03_Function2 {

    def main(args: Array[String]): Unit = {
        
        // TODO 函数式编程
        
        // 1. 函数无参数，无返回值
        def f1(): Unit = {
            println("f1...");
        }
        
        // 函数声明时，如果没有参数，那么参数的小括号可省略
        def f11 : Unit = {
            println("f11....")
        }
        
        // 如果函数声明时没有参数列表的小括号，那么调用时，不允许增加小括号
        f11
        
        // 调用函数
        f1()
        // 如果函数没有参数，那么在调用时，小括号可以省略的
        f1
        
        // 2. 函数有参数，无返回值
        def f2( s : String ): Unit = {
            println( s )
        }
        
        f2( "zhangsan" )
        // 如果函数有参数，那么在调用时，需要传递参数
        //f2
        
        // 3. 函数有参数，有返回值
        def f3( s : String ): String = {
            return "s = " + s
        }
    
        println(f3("zhangsan"))
        
        // 4. 函数无参数，有返回值
        def f4(): String = {
            return "lisi"
        }
    
        println(f4())
        println(f4)
        
        // 5. 函数有多个参数，有返回值
        def f5( a:Int, b:Int ):Int = {
            return a + b
        }
    
        println(f5(10, 20))
        
        // 6. 函数有不确定的参数，无返回值
        // 可变参数:Scala中在参数类型的后面增加星号表示可变
        def f6( a:Int* ): Unit = {
            println(a)
        }
        
        f6()
        f6(10)
        f6(10, 20, 30)
        
        // 7. 可变参数和不可变参数同时声明
        // 不可变参数应该放置在可变参数的前面
        // 函数的参数使用val声明，无法在函数体中进行修改
        def f7( b:Int, a:Int* ): Unit = {
            //b = 20 (X)
            println("f7....")
        }
        
        f7(10)
        f7(10, 20, 30)
        
        // 8. 给参数设定默认值
        // Scala中可以将参数声明时直接进行默认值的设定
        def f8( password:String = "000000" ): Unit = {
//            if ( password == null ) {
//                password = "000000"
//            }
            println(password)
        }
        
        // Scala中如果函数的参数有默认值，那么调用时可以省略参数
        f8()
        // 如果调用函数时指定了参数，那么参数会将默认值覆盖
        f8("123123")
        
        // 9. 带名参数
        def f9( password:String = "000000", name:String ): Unit = {
            println(name + ":" + password)
        }
        
        // 函数在调用时，参数赋值从左到右依次赋值
        f9("zhangsan", "zhangsan")
        // 如果想要给指定函数的参数传值，那么可以采用带名参数
        f9(name="zhangsan")
    }
}
