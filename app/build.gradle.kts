plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.demo.jiguangpush"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.demo.jiguangpush"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // Engagelab 推送配置
        manifestPlaceholders.putAll(mapOf(
            // appKey，需要与控制台上的一样，与packageName是一对一关系
            "ENGAGELAB_PRIVATES_APPKEY" to "e40b783a019f4bf586a7bb53",
            // Engagelab appChannel，用于渠道统计
            "ENGAGELAB_PRIVATES_CHANNEL" to "developer",
            // Engagelab process，Engagelab sdk工作所在的进程，注意:开头
            "ENGAGELAB_PRIVATES_PROCESS" to ":remote"
        ))
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    // Engagelab 推送 SDK
    implementation("com.engagelab:engagelab:4.3.9") // 必须 主包

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}