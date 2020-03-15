package com.atguigu.bigdata.scala.chapter11

object Scala01_Generic {
  def main(args: Array[String]): Unit = {
    // 泛型不可变
//    val test1 : Test[User01] = new Test[Parent01]
//    val test2 : Test[User01] = new Test[User01]
//    val test3 : Test[User01] = new Test[Child01]

    //test( new Parent01() )  X
    test( new User01() )
    test( new Child01() )
  }

  // 泛型的下限：不起作用
//  def test[T >: User01](t : T): Unit = {
//    println("t = " + t)
//  }

  // 泛型的上限
  def test[T <: User01](t : T): Unit = {
    println("t = " + t)
  }

}


// 泛型不可变
//class Test[User01] {
//
//}

// 泛型协变
//class Test[+User01] {
//
//}

// 泛型逆变
//class Test[-User01] {
//
//}


class Parent01 {

}

class User01 extends Parent01 {

}

class Child01 extends User01 {

}