import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.serialization)
}

group = "com.seanproctor.crew"
version = "1.0-SNAPSHOT"

kotlin {
    androidTarget()
    jvm()
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
    }

    sourceSets {
        commonMain {
            dependencies {
                api(compose.runtime)
                implementation(compose.material3)
                implementation(compose.components.resources)
                implementation(libs.kotlinx.serialization.json)
                implementation(compose.components.uiToolingPreview)
            }
        }
    }

    jvmToolchain(17)
}

android {
    namespace = "com.seanproctor.crew.common"
    compileSdk = 35
    defaultConfig {
        minSdk = 24
    }
}

//multiplatformResources {
//    resourcesPackage = "com.seanproctor.crew.common"
//}
