// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.androidLibrary) apply false

    // KSP
    alias(libs.plugins.devToolsKsp)

    // Dagger Hilt
    alias(libs.plugins.dagger.hilt.plugin)  version "2.50" apply false
}