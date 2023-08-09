import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension

plugins {
    kotlin("multiplatform") version "1.9.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    wasm {
        binaries.executable()

        nodejs {
            testTask(Action {
                filter.setExcludePatterns("*BannedTest*")
            })

        }

        browser {
            testTask(Action {
                filter.setExcludePatterns("*BannedTest*")
            })
        }
    }
    js(IR) {
        nodejs {
            testTask(Action {
                filter.setExcludePatterns("*BannedTest*")
            })

        }

        browser {
            testTask(Action {
                filter.setExcludePatterns("*BannedTest*")
            })
        }
    }

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

rootProject.the<NodeJsRootExtension>().apply {
    nodeVersion = "20.3.0"
}
