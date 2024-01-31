import com.android.build.gradle.BaseExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.jetbrainsKotlinxSerialization) apply false
    alias(libs.plugins.ktlint) apply true
    alias(libs.plugins.kover) apply false
}


// See - https://medium.com/@andretmarques/beginners-guide-to-android-modularisation-streamlining-shared-configurations-settings-with-kotlin-ed3fc065e174
// Apply configurations to all sub-projects within the main project
subprojects {
// The 'afterEvaluate' block ensures configurations are applied after the project has been evaluated.
    afterEvaluate {

        // Check if the current project is extension-aware, to make sure we're dealing with an Android project.
        (this as? ExtensionAware)?.extensions?.run {
            // Specific configurations for the App module, helping to keep the app build script clean.
            findByType<BaseAppModuleExtension>()?.run {

                // Default configurations that apply to all build variants unless specifically overridden.
                defaultConfig {
                    applicationId = "com.github.alex_crookes" // The unique identifier for the app
                    versionCode = 1             // Version code, incremented for each release.
                    versionName = "1.0.0"         // User-visible version name.


                }

                // Defines how different build types (debug/release) should be set up.
                buildTypes {
                    debug {
                        isDefault = true       // Makes 'debug' the default build type.
                        isDebuggable = true    // Enables debugging for this build type.
                        applicationIdSuffix =
                            ".debug" // Adds a suffix to the applicationId for the debug build.
                    }
                    release {
                        isMinifyEnabled = true    // Enables code minification.
                        isShrinkResources = true  // Reduces unused resources.
                        isDebuggable = false      // Disables debugging for release builds.
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                    }
                }
            }

            // Additional check to ensure we're configuring an Android project.
            findByType<BaseExtension>()?.run {
                // Sets the Android SDK version to be used for compiling the project.
                setCompileSdkVersion(libs.versions.sdk.compile.get().toInt())

                // Sets the minimum and target SDK versions for the app.
                defaultConfig {
                    // Minimum Android version the app can run on.
                    minSdk = libs.versions.sdk.min.get().toInt()
                    // Android version the app is targeted towards.
                    targetSdk = libs.versions.sdk.target.get().toInt()
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    consumerProguardFiles("consumer-rules.pro")
                }

                // Sets compatibility for the compiled Java code.
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_17 // Source code is written using Java 17.
                    targetCompatibility = JavaVersion.VERSION_17 // Compiled bytecode is compatible with Java 17.
                }
            }
        }
    }
}

// Ensures Kotlin code is compiled to target JVM 17.
tasks.withType<KotlinJvmCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}