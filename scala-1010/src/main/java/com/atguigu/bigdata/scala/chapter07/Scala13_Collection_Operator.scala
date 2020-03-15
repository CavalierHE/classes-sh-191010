package com.atguigu.bigdata.scala.chapter07

object Scala13_Collection_Operator {
  def main(args: Array[String]): Unit = {
      // TODO Scala - 集合 - 数据操作方法（函数）
      val list = List(1,2,3,4)

      // TODO 1.长度
      // java：String[].length,String.length(),List.size()
      //println(list.length)
      //println(list.size)

      // 判断集合是否为空
      //println(Nil.isEmpty)
      //println(list.isEmpty)

      // TODO 2.简单运算
//      println(list.sum)
//      println(list.max)
//      println(list.min)
      // 乘积
//      println(list.product)

      // TODO 3. 数据遍历
      //val iterator:Iterator[Int] = list.iterator
      //val iterator:Iterator[Any] = list.productIterator
//      while (iterator.hasNext) {
//        println(iterator.next())
//      }
      //println(list.mkString(","))
      // 循环遍历
//      for (i <- list) {
//          println(i)
//      }
//      def loop(i:Int):Unit = {
//          println(i)
//      }
      //list.foreach(loop)
      //list.foreach( (i:Int)=>{println(i)})
      //list.foreach( (i)=>{println(i)})
      //list.foreach( (i)=>println(i))
      //list.foreach( i=>println(i))
      //list.foreach( println(_))
      list.foreach(println)
  }
}
