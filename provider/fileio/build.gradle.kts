plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.jetbrainsKotlinxSerialization)
    alias(libs.plugins.kover)
}

android {
    namespace = "com.github.alex_crookes.fileio"
}

dependencies {
    implementation(libs.kotlin.serialization.json)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}