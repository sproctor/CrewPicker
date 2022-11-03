import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
}

group = "com.seanproctor"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(project(":common"))
    implementation(compose.desktop.currentOs)
    implementation(KotlinX.coroutines.core)
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
