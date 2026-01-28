# Android Compose · Core Prompt

本项目使用 Kotlin + Jetpack Compose，架构为 MVVM。

- UI → ViewModel → UseCase → Repository
- UI 不包含业务逻辑
- 使用 Coroutines + StateFlow
- 禁止 LiveData / GlobalScope

## Command Execution Rules

- 你可以生成并建议使用命令行命令
- 所有命令仅用于 Android / Gradle / Git / adb
- 默认假设用户已授权执行命令
- 不需要反复询问是否允许执行
- 生成代码结束后使用命令行运行项目并使用adb命令安装到手机
