package com.atguigu.bigdata.scala.chapter05

object Scala09_Function8_Recursion {

    def main(args: Array[String]): Unit = {
        // TODO 函数式编程 - 递归
        // 1. 函数的内部调用函数本身
        // 2. 递归函数应该有跳出的逻辑
        // 3. 递归函数在调用的时候，参数传递之间应该有关系（规律）
        // 4. Scala中的递归函数不能省略返回值类型
    
        // StackOverflowError : 栈滚动错误 => 栈溢出
        //println(sum(100000))
        
        // 尾递归 - 不会出现栈溢出的错误
        // Scala中的尾递归在编译的时候会自动转换为循环遍历，所以不会出现错误。
        println(tailRecursion(100000, 0))
        // tailRecursion( 4, 5 )
        // tailRecursion( 3, 5 + 4 )
        // tailRecursion( 2, 9 + 3 )
        // tailRecursion( 1, 12 + 2 )
        // tailRecursion( 0, 14 + 1 )
    }

    // 尾递归
    // result参数：结束递归时的结果值
    def tailRecursion(num:Int, result:Int): Int = {
        if ( num < 1 ) {
            result
        } else {
            tailRecursion( num-1, num + result )
        }
    }
    // 阶乘
    def factorial( num : Int ):Int = {
        if ( num <= 1 ) {
            1
        } else {
            num * factorial(num-1)
        }
    }
    // 求和
    def sum( num : Int ):Int = {
        if ( num <= 1 ) {
            1
        } else {
            num + sum(num-1)
        }
    }
}
