/**
 * author : 王星星
 * date : 2026/1/28
 * email : 1099420259@qq.com
 * description : Application 类，用于初始化 Engagelab SDK
 */
package com.demo.jiguangpush

import android.app.Application
import com.engagelab.privates.core.api.MTCorePrivatesApi
import com.engagelab.privates.push.api.MTPushPrivatesApi

/**
 * 用于演示 ENGAGELAB-sdk 配置
 */
class MainApplication : Application() {

    companion object {
        private const val TAG = "MainApplication"
    }

    override fun onCreate() {
        super.onCreate()

        // 必须在application.onCreate中配置，不要判断进程，sdk内部有判断
        MTCorePrivatesApi.configDebugMode(this, true)

        // 后台没升级tag: V3.5.4-newportal-20210823-gamma.57版本，前端必须调用此方法，否则通知点击跳转有问题
        // MTPushPrivatesApi.configOldPushVersion(applicationContext)

        // 初始化推送
        MTPushPrivatesApi.init(this)
    }
}
