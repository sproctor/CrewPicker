plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

dependencies {
    implementation(project(":common"))
    implementation(libs.activity.compose)
}

kotlin {
    jvmToolchain(17)
}

android {
    compileSdk = 35
    namespace = "com.seanproctor.crewpicker.android"
    defaultConfig {
        applicationId = "com.seanproctor.crewpicker.android"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0-SNAPSHOT"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}