package com.atguigu.bigdata.spark.sql.practice

import org.apache.spark.sql.SparkSession

object AreaProductCountAPP {

  def main(args: Array[String]): Unit = {

    //1.创建SparkSession对象
    val spark: SparkSession = SparkSession.builder()
      .master("local[*]")
      .appName("AreaProductCountAPP")
      .enableHiveSupport()
      .getOrCreate()

    import spark.implicits._

    //注册自定义的UDAF
    spark.udf.register("cityRatio", new CityRatioUDAF)

    //2.读取Hive数据
    spark.sql(
      """
        |select
        |    ci.area area,
        |    ci.city_name city_name,
        |    pi.product_name
        |from
        |    (select
        |        click_product_id,
        |        city_id
        |     from
        |         sparkpractice.user_visit_action
        |     where
        |         click_product_id > -1) uv
        |join
        |    sparkpractice.product_info pi
        |on
        |    uv.click_product_id = pi.product_id
        |join
        |    sparkpractice.city_info ci
        |on
        |    uv.city_id = ci.city_id
      """.stripMargin).createTempView("areaCityProductTmpView")

    //3.计算各个大区各个商品的点击次数及城市占比
    spark.sql(
      """
        |select
        |    area,
        |    product_name,
        |    count(*) ct,
        |    cityRatio(city_name) city_ratio
        |from
        |    areaCityProductTmpView
        |group by
        |    area,product_name
      """.stripMargin).createTempView("clickCountTmpView")

    //4.各个大区点击次数排名
    spark.sql(
      """
        |select
        |    area,
        |    product_name,
        |    ct,
        |    city_ratio,
        |    rank() over(partition by area order by ct desc) rk
        |from
        |    clickCountTmpView
      """.stripMargin).createTempView("clickCountRkTmpView")

    //5.取各个大区点击次数前三名的商品
    spark.sql(
      """
        |select
        |    area,
        |    product_name,
        |    ct,
        |    city_ratio
        |from
        |    clickCountRkTmpView
        |where
        |    rk <= 3
      """.stripMargin).show(1000, truncate = false)

    //6.资源关闭
    spark.stop()
  }
}
