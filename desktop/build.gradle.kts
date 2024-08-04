import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

group = "com.seanproctor"
version = "1.0-SNAPSHOT"

kotlin {
    jvm()
    sourceSets {
//        val commonMain by getting {
//            dependencies {
//                implementation(project(":common"))
//                implementation(libs.kotlinx.coroutines.core)
//            }
//        }

        val jvmMain by getting {
            dependencies {
                implementation(project(":common"))
                implementation(libs.kotlinx.coroutines.core)
                implementation(compose.desktop.currentOs)
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "com.seanproctor.crew.desktop.MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "crew"
            packageVersion = "1.0.0"
        }
    }
}
