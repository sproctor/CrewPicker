pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    plugins {
        // See https://jmfayard.github.io/refreshVersions
        id("de.fayard.refreshVersions") version "0.51.0"
////                                # available:"0.60.0"
////                                # available:"0.60.1"
////                                # available:"0.60.2"
////                                # available:"0.60.3"
    }
}

plugins {
    id("de.fayard.refreshVersions")
}

rootProject.name = "crew"

include(":android", ":desktop", ":common", ":web")
