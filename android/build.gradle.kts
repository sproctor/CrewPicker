plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.multiplatform)
}

group "com.seanproctor"
version "1.0-SNAPSHOT"

dependencies {
    implementation(project(":common"))
    implementation(libs.activity.compose)
}

android {
    compileSdk = 34
    defaultConfig {
        applicationId = "com.seanproctor.android"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0-SNAPSHOT"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}