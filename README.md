# 极光推送国际版 Demo

> 基于 Engagelab SDK 的 Android 推送服务集成示例项目

## 📋 项目简介

这是一个集成了极光推送（Engagelab）国际版 SDK 的 Android Demo 项目，展示了如何在 Android 应用中正确配置和使用 Engagelab 推送服务。

- **技术栈**：Kotlin + Jetpack Compose
- **SDK 版本**：Engagelab 4.3.9
- **最低支持版本**：Android 7.0（API 24）
- **目标版本**：Android 14（API 36）

---

## 🎯 核心功能

- ✅ Engagelab SDK 初始化与配置
- ✅ 推送消息接收与处理
- ✅ 自定义通知跳转页面
- ✅ 长连接保活机制
- ✅ 推送事件监听与广播

---

## 🏗️ 项目架构

```
com.demo.jiguangpush/
├── MainApplication.kt           # SDK 初始化入口
├── MainActivity.kt              # 主界面（Jetpack Compose）
├── component/                   # 推送相关组件
│   ├── UserService.kt          # 长连接保活服务
│   ├── UserReceiver.kt         # 推送消息接收器
│   └── UserActivity400.kt      # 通知点击跳转页面
└── ui/theme/                    # UI 主题配置
```

---

## ⚙️ 配置说明

### 1. Gradle 配置

在 `app/build.gradle.kts` 中：

```kotlin
// 依赖引入
implementation("com.engagelab:engagelab:4.3.9")

// Manifest 占位符配置
manifestPlaceholders.putAll(mapOf(
    "ENGAGELAB_PRIVATES_APPKEY" to "e40b783a019f4bf586a7bb53",  // 你的 AppKey
    "ENGAGELAB_PRIVATES_CHANNEL" to "developer",                 // 渠道标识
    "ENGAGELAB_PRIVATES_PROCESS" to ":remote"                    // SDK 工作进程
))
```

### 2. Application 初始化

在 `MainApplication.onCreate()` 中：

```kotlin
// 开启调试模式（生产环境需关闭）
MTCorePrivatesApi.configDebugMode(this, true)

// 初始化推送服务
MTPushPrivatesApi.init(this)
```

---

## 🔧 核心组件说明

### UserService

继承 `MTCommonService`，用于保持推送长连接更长时间存活。

```kotlin
class UserService : MTCommonService()
```

### UserReceiver

自定义广播接收器，处理推送消息、通知点击等事件。

### UserActivity400

通知点击后的跳转目标页面，可自定义处理逻辑。

---

## 🚀 快速开始

### 1. 克隆项目

```bash
git clone <项目地址>
cd JpushDemo
```

### 2. 配置 AppKey

在 `app/build.gradle.kts` 中替换为你在 Engagelab 控制台申请的 AppKey：

```kotlin
"ENGAGELAB_PRIVATES_APPKEY" to "你的AppKey"
```

### 3. 运行项目

```bash
./gradlew assembleDebug
```

或直接在 Android Studio 中运行。

---

## 📱 测试推送

### 方式一：使用 Engagelab 控制台

1. 登录 [Engagelab 控制台](https://www.engagelab.com/)
2. 进入你的应用
3. 选择 "推送" → "创建推送"
4. 填写标题、内容并发送

### 方式二：使用 API 推送

参考 Engagelab 官方 API 文档进行服务端推送。

---

## 📝 注意事项

1. **AppKey 配置**：必须与包名一一对应
2. **进程配置**：SDK 运行在独立进程（`:remote`），注意进程间通信
3. **调试模式**：生产环境务必关闭 `configDebugMode`
4. **权限声明**：SDK 内部已声明必要权限，无需手动添加

---

## 🔗 相关链接

- [Engagelab 官网](https://www.engagelab.com/)
- [Engagelab Android SDK 文档](https://docs.engagelab.com/)
- [极光推送控制台](https://www.jiguang.cn/)

---

## 👤 作者信息

**作者**：王星星  
**邮箱**：1099420259@qq.com  
**创建日期**：2026/1/28

---

## 📄 License

本项目仅供学习参考，商业使用请遵守 Engagelab SDK 相关协议。
