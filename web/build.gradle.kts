plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("dev.icerock.mobile.multiplatform-resources")
}

group = "com.seanproctor.crew"
version = "1.0-SNAPSHOT"


kotlin {
    js(IR) {
        browser()
        binaries.executable()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("dev.icerock.moko:resources:0.20.1")
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(project(":common"))
                implementation(compose.web.core)
            }
        }
        val jsTest by getting {

        }
    }
}

compose.experimental {
    web.application {}
}

multiplatformResources {
    multiplatformResourcesPackage = "com.seanproctor.crew"
}