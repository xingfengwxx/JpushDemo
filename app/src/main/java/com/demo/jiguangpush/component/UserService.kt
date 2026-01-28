/**
 * author : 王星星
 * date : 2026/1/28 ${new java.text.SimpleDateFormat("HH:mm").format(new java.util.Date())}
 * email : 1099420259@qq.com
 * description : 继承 MTCommonService，使长连接更长时间存活
 */
package com.demo.jiguangpush.component

import com.engagelab.privates.common.component.MTCommonService

/**
 * 开发者继承MTCommonService，可以使长连接更长时间存活
 * 空实现即可
 */
class UserService : MTCommonService()
