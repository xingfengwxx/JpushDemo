/**
 * author : 王星星
 * date : 2026/1/28
 * email : 1099420259@qq.com
 * description : 用于演示通知点击后的 Activity 跳转
 */
package com.demo.jiguangpush.component

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.demo.jiguangpush.R

/**
 * 用于演示-点击通知后activity跳转
 *
 * 确保没有调用MTPushPrivatesApi.configOldPushVersion(Context)，否则通知点击跳转不会跳转到此页面
 * 不需要调用MTPushPrivatesApi.reportNotificationOpened，sdk内部已做处理
 */
class UserActivity400 : Activity() {

    companion object {
        private const val TAG = "UserActivity400"
    }

    private lateinit var tvMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        tvMessage = findViewById(R.id.tv_message)
        onIntent(intent)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        onIntent(intent)
    }

    private fun onIntent(intent: Intent?) {
        try {
            Toast.makeText(this, TAG, Toast.LENGTH_SHORT).show()
            if (intent == null) {
                return
            }
            // 3.4.0版本开始不再使用对象，而使用json数据
            val notificationMessage = intent.getStringExtra("message_json")
            if (notificationMessage == null) {
                return
            }
            Log.d(TAG, "notificationMessage:$notificationMessage")
            tvMessage.text = notificationMessage
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
        }
    }
}
