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

}

dependencies {
    implementation(libs.kotlin.serialization.json)
    implementation(project(":provider:preferences"))
    implementation(project(":provider:fileio"))

    implementation(libs.ktor.client)
    implementation(libs.ktor.client.negotiation)
    implementation(libs.ktor.client.json)
    implementation(libs.ktor.client.android)

    testImplementation(libs.junit)
    testImplementation(libs.kotlin.coroutines.test)
}
