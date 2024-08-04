plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.moko.resources)
}

group = "com.seanproctor.crew"
version = "1.0-SNAPSHOT"


kotlin {
    js {
        browser()
        binaries.executable()
    }
    sourceSets {
//        val commonMain by getting {
//            dependencies {
//                implementation(project(":common"))
//                implementation(libs.moko.resources)
//            }
//        }
        val jsMain by getting {
//            dependsOn(commonMain)
            dependencies {
                implementation(project(":common"))
                implementation(compose.ui)
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.moko.resources)
            }
        }
    }
}
