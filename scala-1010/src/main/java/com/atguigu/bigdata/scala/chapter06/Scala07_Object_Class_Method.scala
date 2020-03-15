package com.atguigu.bigdata.scala.chapter06

object Scala07_Object_Class_Method {

  def main(args: Array[String]): Unit = {
    // TODO - Scala - 面向对象 - Class - 方法
    // Scala中声明了类，同时会具备很多的方法，有的来自于
    // java，有的来自于scala
    val user = new User07()
    user.id = 1

    val user1 = new User07()
    user1.id = 1

    println(user.equals(user1))

    // 获取类型信息
    val c:Class[User07] = classOf[User07]
    println(c)

    //  [类名]：泛型
    //classOf[User07]
  }

}

class User07 {
  var id : Int = _
  override def equals(o: Any): Boolean = {
    // 判断对象的类型
    if(o.isInstanceOf[User07]){
      // 将对象转换类型
      val other:User07 = o.asInstanceOf[User07]
      other.id == this.id
    } else {
      false
    }
  }
}
