package com.atguigu.bigdata.scala.chapter11

object Scala02_Generic1 {
  def main(args: Array[String]): Unit = {
    val dog: Dog = new Dog()
    val cat: Cat = new Cat()
    val lion: Lion = new Lion()

    val dogContainer: PetContainer[Dog] = new PetContainer[Dog](dog)
    val catContainer: PetContainer[Cat] = new PetContainer[Cat](cat)
    //val lionContainer: PetContainer[Lion] = new PetContainer[Lion](lion) //Error
  }

}


abstract class Animal {
  val name: String
}

abstract class Pet extends Animal {

}

class Dog extends Pet {
  override val name: String = "dog"
}

class Cat extends Pet {
  override val name: String = "cat"
}

class Lion extends Animal {
  override val name: String = "lion"
}

// 泛型使用 >:表示 下限，所以在使用时，必须是父类型
// 声明在类上可以起作用，但是这种方式声明在函数时是有问题的。
class PetContainer[P <: Pet](val pet: P) {
}