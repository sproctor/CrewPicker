plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.moko.resources)
}

group = "com.seanproctor.crew"
version = "1.0-SNAPSHOT"

kotlin {
    androidTarget()
    jvm("desktop")
    js("web") {
        browser()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                implementation(compose.material3)
                implementation(libs.moko.resources)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.moko.resources.compose)
            }
        }
        val desktopMain by getting {
            dependencies {
                api(compose.preview)
            }
        }
    }

    jvmToolchain(17)
}

android {
    namespace = "com.seanproctor.crew.common"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}

multiplatformResources {
    resourcesPackage = "com.seanproctor.crew.common"
}
