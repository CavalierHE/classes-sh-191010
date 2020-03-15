package com.atguigu.bigdata.spark.core.project.service

import com.atguigu.bigdata.spark.core.project.bean.UserVisitAction
import com.atguigu.bigdata.spark.core.project.common.{AbstractService, TDao}
import com.atguigu.bigdata.spark.core.project.dao.PageFlowAnalysisDao
import org.apache.spark.rdd.RDD

class PageFlowAnalysisService extends AbstractService{

  private val pageFlowAnalysisDao = new PageFlowAnalysisDao

  override def getDao(): TDao = pageFlowAnalysisDao

  def analysis1() = {
    val actionRDD: RDD[UserVisitAction] = getUserVisitActions()

    // 需要关心页面单跳转换率的列表
    // 1-2/1，2-3/2，3-4/3，4-5/4，5-6/5，6-7/6
    val flowIds = List(1,2,3,4,5,6,7)
    // 1-2,2-3,3-4,4-5,5-6,6-7
    val zipFlowIds = flowIds.zip(flowIds.tail).map(t=>t._1 + "-" + t._2)

    // TODO 计算分母
    // TODO 将页面进行分组聚合
    // TODO 将数据进行过滤
    val filterRDD: RDD[UserVisitAction] = actionRDD.filter(action=>flowIds.init.contains(action.page_id.toInt))

    val pageToOneRDD: RDD[(Long, Long)] = filterRDD.map(action=>{(action.page_id,1L)})
    val pageToSumRDD: RDD[(Long, Long)] = pageToOneRDD.reduceByKey(_+_)
    val pageCount: Array[(Long, Long)] = pageToSumRDD.collect()

    // TODO 计算分子
    // TODO 将日志数据根据Session进行分组
    val groupRDD: RDD[(String, Iterable[UserVisitAction])] = actionRDD.groupBy(_.session_id)

    // TODO 将分组后的数据进行时间的排序（升序）
    val sessionRDD: RDD[(String, List[(String, Int)])] = groupRDD.mapValues(
      datas => {
        val actions: List[UserVisitAction] = datas.toList.sortWith(
          (left, right) => {
            left.action_time < right.action_time
          }
        )
        // TODO 将排序后的数据进行结构的转换
        val pageids: List[Long] = actions.map(_.page_id)
        // TODO 将连续页面进行关联，然后分组聚合
        // 2,3,7,8
        // 3,7,8
        // 2-3, 3-7, 7-8
        // 2 3 7 8
        // 3 7 8
        val zips: List[(Long, Long)] = pageids.zip(pageids.tail)
        val flowToOne: List[(String, Int)] = zips.map {
          case (pageid1, pageid2) => {
            (pageid1 + "-" + pageid2, 1)
          }
        }

        // 将数据进行过滤
        flowToOne.filter{
          case(ids,one) => {
            zipFlowIds.contains(ids)
          }
        }
      }
    )

    // 将排序后的结果进行结构的转换
    // (2-3,1), (3-5,1)
    val pageFlowToOneRDD: RDD[(String, Int)] = sessionRDD.map(_._2).flatMap(list=>list)
    // (2-3,10), (3-5,11)
    val pageFlowToSumRDD: RDD[(String, Int)] = pageFlowToOneRDD.reduceByKey(_+_)

    // TODO 获取最终的页面单跳转化率
    pageFlowToSumRDD.foreach{
      case (pageflow,sum) => {
        // 获取分母的数据
        val pageCountMap: Map[Long, Long] = pageCount.toMap
        val pid: String = pageflow.split("-")(0)
        val value: Long = pageCountMap.getOrElse(pid.toLong,1L)

        println(pageflow + "=" + (sum.toDouble / value))
      }
    }
  }


  def analysis() = {

    val actionRDD: RDD[UserVisitAction] = getUserVisitActions()


    // TODO 计算分母
    // TODO 将页面进行分组聚合
    val pageToOneRDD: RDD[(Long, Long)] = actionRDD.map(action=>{(action.page_id,1L)})
    val pageToSumRDD: RDD[(Long, Long)] = pageToOneRDD.reduceByKey(_+_)
    val pageCount: Array[(Long, Long)] = pageToSumRDD.collect()

    // TODO 计算分子



    // TODO 将日志数据根据Session进行分组
    val groupRDD: RDD[(String, Iterable[UserVisitAction])] = actionRDD.groupBy(_.session_id)

    // TODO 将分组后的数据进行时间的排序（升序）
    val sessionRDD: RDD[(String, List[(String, Int)])] = groupRDD.mapValues(
      datas => {
        val actions: List[UserVisitAction] = datas.toList.sortWith(
          (left, right) => {
            left.action_time < right.action_time
          }
        )
        // TODO 将排序后的数据进行结构的转换
        val pageids: List[Long] = actions.map(_.page_id)
        // TODO 将连续页面进行关联，然后分组聚合
        // 2,3,7,8
        // 3,7,8
        // 2-3, 3-7, 7-8
        // 2 3 7 8
        // 3 7 8
        val zips: List[(Long, Long)] = pageids.zip(pageids.tail)
        zips.map {
          case (pageid1, pageid2) => {
            (pageid1 + "-" + pageid2, 1)
          }
        }
      }
    )

    // 将排序后的结果进行结构的转换
    // (2-3,1), (3-5,1)
    val pageFlowToOneRDD: RDD[(String, Int)] = sessionRDD.map(_._2).flatMap(list=>list)
    // (2-3,10), (3-5,11)
    val pageFlowToSumRDD: RDD[(String, Int)] = pageFlowToOneRDD.reduceByKey(_+_)

    // TODO 获取最终的页面单跳转化率
    pageFlowToSumRDD.foreach{
      case (pageflow,sum) => {
        // 获取分母的数据
        val pageCountMap: Map[Long, Long] = pageCount.toMap
        val pid: String = pageflow.split("-")(0)
        val value: Long = pageCountMap.getOrElse(pid.toLong,1L)

        println(pageflow + "=" + (sum.toDouble / value))
      }
    }
  }
}
