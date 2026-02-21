
plugins {
    alias(libs.plugins.kotlinMultiplatform)
}

kotlin {
    macosArm64 {
        binaries {
            executable {
                entryPoint = "xyz.malefic.macalicious.main"
            }
        }
    }
    macosX64 {
        binaries {
            executable {
                entryPoint = "xyz.malefic.macalicious.main"
            }
        }
    }

    applyDefaultHierarchyTemplate()

    targets.all {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    optIn.add("kotlinx.cinterop.ExperimentalForeignApi")
                }
            }
        }
    }

    sourceSets {
        commonMain.dependencies {
            // put your Multiplatform dependencies here
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}
