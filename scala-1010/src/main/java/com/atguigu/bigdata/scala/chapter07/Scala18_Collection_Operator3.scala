package com.atguigu.bigdata.scala.chapter07

object Scala18_Collection_Operator3 {
  def main(args: Array[String]): Unit = {
      // TODO Scala - 集合 - 数据操作方法（函数）
      val list1 = List(1,2,3,4,5,6,7,8)
      val list2 = List(4,5,6,7,8)

      // 合（并）集
      //println(list1.union(list2))
      // 交集
      //println(list1.intersect(list2))
      // 差集
      //println(list1.diff(list2))

      // 拉链：两个集合数据的组合，相同位置的数据组合在一起
      // 如果两个集合的数据不匹配，那么会采用数量最好的那个进行拉链
      //println(list1.zip(list2))

      // 滑动
      // 需求：求集合中连续3个数据的和
      // 将集合中的一部分数据作为整体来使用，将这个范围称之为窗口
      // 这个范围可以动态发生改变，可以根据需求进行滑动
      // 所以这个窗口也称之滑动窗口
      val iterator = list1.sliding(3,2)
      while (iterator.hasNext) {
          println(iterator.next())
      }
  }
}
















