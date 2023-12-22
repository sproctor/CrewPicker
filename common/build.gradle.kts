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
    js("web", IR) {
        browser()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                implementation(libs.moko.resources)
                implementation(libs.kotlinx.serialization.json)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependsOn(commonMain) // workaround moko bug
            dependencies {
                implementation(libs.moko.resources.compose)
            }
        }
        val androidUnitTest by getting {
            dependencies {
                implementation(libs.junit)
            }
        }
        val desktopMain by getting {
            dependsOn(commonMain) // workaround moko bug
            dependencies {
                api(compose.preview)
            }
        }
        val desktopTest by getting
        val webMain by getting {
            dependsOn(commonMain) // workaround moko bug
            dependencies {
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
    multiplatformResourcesPackage = "com.seanproctor.crew.common"
}