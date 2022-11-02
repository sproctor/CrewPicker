plugins {
    id("org.jetbrains.compose")
    id("com.android.application")
    kotlin("android")
}

group "com.seanproctor"
version "1.0-SNAPSHOT"

dependencies {
    implementation(project(":common"))
    implementation(libs.activity.compose)
}

android {
    compileSdkVersion(33)
    defaultConfig {
        applicationId = "com.seanproctor.android"
        minSdkVersion(24)
        targetSdkVersion(33)
        versionCode = 1
        versionName = "1.0-SNAPSHOT"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}