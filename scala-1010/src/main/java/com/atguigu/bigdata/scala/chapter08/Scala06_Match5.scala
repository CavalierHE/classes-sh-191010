package com.atguigu.bigdata.scala.chapter08

object Scala06_Match5 {

   def main(args: Array[String]): Unit = {
       // TODO Scala - 模式匹配 - 匹配对象
       // 构建对象的时候，可以采用new的语法方式
       // 也可以采用伴生对象的apply方法的方式

       // 当对象进行模式匹配的时候，会调用特定的方法unapply方法
       // unapply方法用对象反推参数，如果参数和指定的值保持一致，那么匹配成功
       // 如果不一致，匹配失败

       // apply : (zhangsan,11) => new User06
       // unapply : new User06 => (name, age) => (zhangsan,11)
       val user: User06 = User06("zhangsan", 11)
       val result = user match {
         case User06("zhangsan", 12) => "yes"
         case _ => "no"
       }

       println(result)
   }
}

class User06(val name: String, val age: Int)

object User06 {
  def apply(name: String,age: Int): User06 = new User06(name,age)

  def unapply(user: User06): Option[(String, Int)] = {
    if (user == null)
      None
    else
      Some(user.name, user.age)
  }
}