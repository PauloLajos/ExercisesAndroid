@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)

    alias(libs.plugins.devToolsKsp)
    alias(libs.plugins.dagger.hilt.plugin)
}

android {
    namespace = "hu.paulolajos.daggerhilt"
    compileSdk = 34

    defaultConfig {
        applicationId = "hu.paulolajos.daggerhilt"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)

    // Hilt
    implementation(libs.dagger.hilt.android)
    implementation(libs.constraintlayout)
    ksp(libs.dagger.hilt.compiler)

    // Glide
    implementation(libs.glide)

    // ViewModels
    implementation(libs.androidx.activity.ktx)
    implementation(libs.lifecycle.viewmodel)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}