package com.atguigu.bigdata.spark.core.project.common

import com.atguigu.bigdata.spark.core.project.util.ProjectUtil


// 通用Application
trait TApplication {

    // 启动应用
    def startOnLocal(op: => Unit): Unit = {
        start( "local[*]", "Application" )(op)
    }

    def start(master:String, appname:String)(op: => Unit): Unit = {
        ProjectUtil.getSparkContext

        // TODO 控制抽象 ：动态逻辑代码
        try {
            op
        } catch {
            case ex: Exception => ex.printStackTrace()
        }

        ProjectUtil.stop()
    }
}
