// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlinAndroid) apply false

    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.devToolsKsp) apply false
    alias(libs.plugins.kotlin.parcelize) apply false
    alias(libs.plugins.dagger.hilt.plugin) apply false
    alias(libs.plugins.navigation.safeargs.kotlin) apply false
}