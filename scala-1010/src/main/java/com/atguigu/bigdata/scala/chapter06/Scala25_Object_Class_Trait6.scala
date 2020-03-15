package com.atguigu.bigdata.scala.chapter06

object Scala25_Object_Class_Trait6 {

  def main(args: Array[String]): Unit = {

    //  TODO 面向对象 - 特质
    //  特质功能的叠加
    //  如果一个类中混入了多个特质，而多个特质中含有相同的方法(功能)
    //  这就涉及到功能叠加顺序
    //  最外层的特质 => 内层的特质
    //  执行顺序为：从后往前，从右向左
    //  在功能叠加时，super关键字表示的不是父类对象(特质)，表示上一个特质
    new MySQL().insertData()
  }
}

trait Oper {
  def insertData():Unit = {
      println("插入数据")
  }
}

trait FileOper extends Oper {
  override def insertData():Unit = {
      print("向文件中")
      super[Oper].insertData()
  }
}

trait MemoryOper extends Oper {
  override def insertData():Unit = {
    print("向内存中")
    super.insertData()
  }
}

class MySQL extends MemoryOper with FileOper {

}
