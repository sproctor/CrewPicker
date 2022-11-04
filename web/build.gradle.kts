plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "com.seanproctor.crew"
version = "1.0-SNAPSHOT"


kotlin {
    js(IR) {
        browser()
        binaries.executable()
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(project(":common"))
                implementation(compose.web.core)
            }
        }
        val jsTest by getting
    }
}

compose.experimental {
    web.application {}
}
