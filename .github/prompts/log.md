# Log Rules

- 调试日志一律使用com.blankj.utilcode.util.LogUtils工具类，使用方式如下：

  - ```kotlin
    LogUtils.i("内容")
    LogUtils.d("getAllCategoriesForDropdown: type=$type, result=$result")
    LogUtils.e("内容：${e.message}")
    ```