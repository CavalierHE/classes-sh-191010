package com.atguigu.bigdata.scala.chapter07

object Scala15_Collection_Operator2 {
  def main(args: Array[String]): Unit = {
      // TODO Scala - 集合 - 数据操作方法（函数）
      val list = List(1,2,3,4,5,6)

      // TODO 映射转换 A->B, A->B
      // 将集合中的数据转换成其他的数据，将转换后的结果放置在新的集合中
      def map(i:Int):String = {
          "i = " + i.toString
      }
      //println(list.map(map))
      //println(list.map((i:Int) => i*2))
      //println(list.map(_*2))

      // TODO 扁平化
      // 所谓的扁平化，其实就是将整体拆分成一个一个的个体来使用
      // flatten方法只能针对于外层集合进行扁平化操作，无法对内层集合进行扁平化
      //val list1:List[List[Int]] = List(List(1,2),List(3,4))
      //val list1 = List(List(List(1,2)),List(List(3,4)))
      //val flatten = list1.flatten.flatten
      //val flatten = list1.flatten
      //println(flatten.map(_*2))

      // TODO 扁平映射 = 扁平化 + 映射
      //val list1 = List(List(1,2),List(3,4))
      //println(list1.flatMap(list => list.map(_*2)))
      //println(list1.flatMap(list => list))

      //val stringList = List("Hello World","Hello Scala","Hello Spark")
      //val strings = stringList.flatMap(s => s.split(" "))
      //println(strings)
      //val flatten = stringList.flatten
      //println(flatten)

      // TODO 过滤
      // 按照指定的规则对集合中的每一条数据进行筛选过滤
      // 满足条件的数据保留下来，不满足条件的数据丢弃
      //println(list.filter(num => num % 2 == 0))

      // TODO 分组
      // 按照指定的规则对每个数据进行分组操作
      // 指定函数规则的返回值作为分组的key，相同的key的数据放置在一个组中
      // 返回结果是一个Map，其中的key就是分组key，其中的value就是满足条件的数据集合
      // 奇数，偶数
      //println(list.groupBy(num => num % 2))

      // TODO 排序：升序（1,2,3），降序（3,2,1）
      val list1 = List(3,1,4,2,5)
      // 通过指定的规则进行排序
      //println(list1.sortBy(num => num))

      val list2 = List("1", "2", "12", "21", "3")
      //println(list2.sortBy(s => s))
      // 集合排序默认为升序
      //println(list2.sortBy(s => s.toInt))
      // 降序
      //println(list2.sortBy(s => s.toInt).reverse)
      println(list2.sortBy(s => s.toInt)(Ordering.Int.reverse))

      // 自定义排序
      val user1 = new User15()
      user1.age = 30
      val user2 = new User15()
      user2.age = 40
      val userList = List(user1,user2)

      println(userList.sortWith(
          (left:User15,right:User15) => {
              // 升序
              //left.age < right.age
              // 降序
              left.age > right.age
          }
      ))
  }
}

class User15 {
  var age : Int = 0

  override def toString: String = {
    "user[age="+age+"]"
  }
}















