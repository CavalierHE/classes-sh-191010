package com.atguigu.bigdata.scala.chapter02

object Scala06_String {
    def main(args: Array[String]): Unit = {
        
        // TODO 字符串
        val name :String = "zhangsan"
        
        // 字符串连接
        println("Hello " + name)
    
        // 传值字符串
        printf("name=%s\n", name)
        
        // JSON => JavaScript Object Notation
        // JavaScript弱类型的语言
        // obj = { "name":"zhangsan", "age":20 }
        // JSON 字符串
        // 相同类型的引号不能嵌套使用
        // """", ''''
        val json : String = "{ \"name\":\"zhangsan\" }"
        val json1 : String = "{ \"name\":\""+name+"\" }"
        
        // 插值字符串
        // 将变量值插入到字符串
        //println(s"name=$name")
        //println(s"name=${name.length}")
        //println("name=" + name.length)
        
        //println("name:zhangsan\nage:20\nsex:男")
//        println(
//            """name:zhangsan
//              age:20
//              sex:男
//            """)
        // | 顶格符
        // 多行格式化字符串
        // SQL
        println(
            """
              | select
              |    *
              | from user
              | where id = 1
            """.stripMargin)
    }
}
