/**
 * author : 王星星
 * date : 2026/1/28
 * email : 1099420259@qq.com
 * description : 继承 MTCommonReceiver，接收 SDK 的方法回调（所有回调均在主线程）
 */
package com.demo.jiguangpush.component

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.engagelab.privates.common.component.MTCommonReceiver
import com.engagelab.privates.core.api.MTCorePrivatesApi
import com.engagelab.privates.push.api.CustomMessage
import com.engagelab.privates.push.api.NotificationMessage
import com.engagelab.privates.push.api.PlatformTokenMessage

/**
 * 开发者继承MTCommonReceiver，可以获得sdk的方法回调
 * 所有回调均在主线程
 */
class UserReceiver : MTCommonReceiver() {

    companion object {
        private const val TAG = "UserReceiver"
    }

    /**
     * 应用通知开关状态回调
     *
     * @param context 不为空
     * @param enable  通知开关是否开，true为打开，false为关闭
     */
    override fun onNotificationStatus(context: Context, enable: Boolean) {
        Log.i(TAG, "onNotificationStatus:$enable")
        Toast.makeText(context.applicationContext, "onNotificationStatus $enable", Toast.LENGTH_SHORT).show()
    }

    /**
     * 长连接状态回调
     *
     * @param context 不为空
     * @param enable  是否连接
     */
    override fun onConnectStatus(context: Context, enable: Boolean) {
        Log.i(TAG, "onConnectState:$enable")
        Toast.makeText(context.applicationContext, "onConnectStatus $enable", Toast.LENGTH_SHORT).show()
        // 长连接成功可获取registrationId
        if (enable) {
            val registrationId = MTCorePrivatesApi.getRegistrationId(context)
            Log.i(TAG, "registrationId:$registrationId")
        }
    }

    /**
     * 通知消息到达回调
     *
     * @param context             不为空
     * @param notificationMessage 通知消息
     */
    override fun onNotificationArrived(context: Context, notificationMessage: NotificationMessage) {
        Log.i(TAG, "onNotificationArrived:${notificationMessage.toString()}")
    }

    /**
     * 通知消息在前台不显示
     *
     * @param context             不为空
     * @param notificationMessage 通知消息
     */
    override fun onNotificationUnShow(context: Context, notificationMessage: NotificationMessage) {
        Log.i(TAG, "onNotificationUnShow:${notificationMessage.toString()}")
    }

    /**
     * 通知消息点击回调
     *
     * @param context             不为空
     * @param notificationMessage 通知消息
     */
    override fun onNotificationClicked(context: Context, notificationMessage: NotificationMessage) {
        Log.i(TAG, "onNotificationClicked:${notificationMessage.toString()}")
    }

    /**
     * 通知消息删除回调
     *
     * @param context             不为空
     * @param notificationMessage 通知消息
     */
    override fun onNotificationDeleted(context: Context, notificationMessage: NotificationMessage) {
        Log.i(TAG, "onNotificationDeleted:${notificationMessage.toString()}")
    }

    /**
     * 自定义消息回调
     *
     * @param context       不为空
     * @param customMessage 自定义消息
     */
    override fun onCustomMessage(context: Context, customMessage: CustomMessage) {
        Log.i(TAG, "onCustomMessage:${customMessage.toString()}")
    }

    /**
     * 厂商token消息回调
     *
     * @param context              不为空
     * @param platformTokenMessage 厂商token消息
     */
    override fun onPlatformToken(context: Context, platformTokenMessage: PlatformTokenMessage) {
        Log.i(TAG, "onPlatformToken:${platformTokenMessage.toString()}")
    }
}
