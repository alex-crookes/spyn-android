plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.jetbrainsKotlinxSerialization)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.kover)
}

ktlint {
    debug.set(true)
//    version = "0.49.1"
    verbose = true

//    disabledRules.set(["no-wildcard-imports"])
}

koverReport {
    verify {
        rule("min coverage 60") {
            isEnabled = true
            bound { minValue = 60 }
        }
    }
    filters {
        excludes {
            classes(listOf("*di.*", "*Factory*"))

            // annotatedBy( listOf("*Generated", "*CustomAnnotationToExclude") )
        }
    }
    androidReports("release") {
        filters {
            // override report filters for all reports for `release` build variant
            // all filters specified by the level above cease to work
        }

        xml { /* XML report config for `release` build variant */ }
        html { /* HTML report config for `release` build variant */ }
        verify { /* verification config for `release` build variant */ }
        log { /* logging config for `release` build variant */ }
    }
}

android {
    namespace = "com.github.alex_crookes.spyn_android.discogsapi"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.kotlin.serialization.json)
    implementation(project(":provider:fileio"))

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
