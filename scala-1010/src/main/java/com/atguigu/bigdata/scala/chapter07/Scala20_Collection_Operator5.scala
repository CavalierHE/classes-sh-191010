package com.atguigu.bigdata.scala.chapter07

object Scala20_Collection_Operator5 {
  def main(args: Array[String]): Unit = {
      // TODO Scala - 集合 - 数据操作方法（函数）
      val list = List(1,2,3,4)

      // TODO 2. 折叠 - 聚合
      // 2.1 当数据类型不一致的时候，可以考虑fold方法来做聚合
      // 2.2 reduce方法只能对集合内部的数据进行聚合处理，如果想要和集合
      // 的外部数据进行聚合，就需要采用fold方法
      // fold方法的第一个参数列表中参数表示 初始值（零值），用于进行计算的第一个值
      // fold方法的第二个参数列表中的参数表示数据计算的规则
      // fold方法要求初始值和计算的每一个值的类型相同，如果类型不相同，
      // 那么需要使用foldLeft
//      val i: Int = list.fold(5)(_+_)
//      println(i)
//      var r = list.scan(5)(_+_)
//      println(r)
//      val str: String = list.foldLeft("")(_+_)
//      println(str)
//      val s = list.scanLeft("")(_+_)
//      println(s)

//      val i = list.foldRight(5)(_-_)
//      println(i)

      // TODO 扫描 - scan
      // scan和fold方法很类似，但是scan会保存中间计算的结果
      val ints = list.scanRight(5)(_-_)
      println(ints)
  }
}
















