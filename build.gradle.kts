import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform") version "1.6.20"
    id("org.jetbrains.compose") version "1.2.0-alpha01-dev679"
}

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    js(IR) {
        browser()
        binaries.executable()
    }
    sourceSets {
        val ktorVersion = "2.0.1"
        val jsMain by getting {
            dependencies {
                implementation(compose.web.core)
                implementation(compose.web.svg)
                implementation(compose.runtime)
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-serialization:$ktorVersion")
                implementation("io.ktor:ktor-client-logging:$ktorVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.1.0")
            }
        }
    }
}



