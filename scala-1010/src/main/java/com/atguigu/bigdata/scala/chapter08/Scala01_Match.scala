package com.atguigu.bigdata.scala.chapter08

object Scala01_Match {

  def main(args: Array[String]): Unit = {
    // Scala - 模式匹配
    val sex = "女"

    // TODO 当Case语句满足条件时，会自动执行=>后续的代码
    //      但是不需要增加break语句，因为有执行范围（大括号）
    //      即使没有大括号，也无需break语句，不会出现所谓的穿透现象
    // TODO 如果所有的case语句都不满足条件，那么会匹配下划线的case
    //      如果所有的case条件都不成立，并且没有下划线分支
    //      那么执行时，会出现MatchError
    // TODO 如果调整case语句的顺序，将下划线放置在最前面
    //      那么其他case会无法执行，但是不会报错
    //      一般推荐将下划线分支放置在模式匹配的最后
    sex match {
      case "男" =>
        println("性别为男")
      case "女" =>
        println("性别为女")
      case _ =>
        println("未知")
    }
  }
}
