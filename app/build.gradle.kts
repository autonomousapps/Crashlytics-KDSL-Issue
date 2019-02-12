plugins {
    id("com.android.application")
    id("io.fabric")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "com.example.crashlyticskdsl"
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("debug") {
            ext.set("alwaysUpdateBuildId", false)
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation("com.android.support:appcompat-v7:28.0.0")

    compile("com.crashlytics.sdk.android:crashlytics:2.9.9@aar") {
        isTransitive = true
    }
}
