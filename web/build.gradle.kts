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
                implementation(project(":common"))
                implementation(libs.moko.resources)
            }
        }
        val jsMain by getting {
            dependsOn(commonMain)
            dependencies {
            }
        }
    }
}

compose.experimental {
    web.application {}
}

multiplatformResources {
    multiplatformResourcesPackage = "com.seanproctor.crew"
}