plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.github.alex_crookes.repo.catalog"
}

dependencies {
    implementation(project(":provider:discogsapi"))

    testImplementation(libs.junit)
    testImplementation(libs.kotlin.serialization.json)
    testImplementation(libs.kotlin.coroutines.test)
    testImplementation(project(":provider:fileio"))

    androidTestImplementation(libs.androidx.junit)
}