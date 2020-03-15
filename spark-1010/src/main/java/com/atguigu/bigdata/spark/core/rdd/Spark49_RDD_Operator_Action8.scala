package com.atguigu.bigdata.spark.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark49_RDD_Operator_Action8 {
    def main(args: Array[String]): Unit = {

      val conf = new SparkConf().setMaster("local[*]").setAppName("action")
      val sc = new SparkContext(conf)

      val rdd:RDD[Int] = sc.makeRDD(List(1,2,3,4))

      val user:User = new User()

      val emp:Emp = new Emp()
      // Exception：Task not serializable
      // 算子
      // Driver中的数据如果需要在Executor端使用，那么这个数据必须要能序列化

      // 在当前场合下，没有提交作业，Driver就可以识别对象没有序列化
      // 因为框架提供一个闭包检测功能，可以判断闭包中的对象是否序列化
      // 如果引用第三方对象没有序列化，会发生异常

      // 分布式计算
      rdd.foreach(
        num => {
          println(emp.age + num)
        }
      )

      println("*******************")

      // 单点计算
      rdd.collect.foreach(
        num => {
          println(user.age + num)
        }
      )

      sc.stop()
    }

//    class User extends java.io.Serializable{
//      val age:Int = 18
//    }

  class User {
    val age:Int = 18
  }

  //样例类，编译时，类会自动实现可序列化接口
  case class Emp() {
    val age:Int = 18
  }

}
