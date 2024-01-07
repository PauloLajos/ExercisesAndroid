plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.devToolsKsp)
    alias(libs.plugins.dagger.hilt.plugin)
}

android {
    namespace = "hu.paulolajos.getcurrentlocation"
    compileSdk = 34

    defaultConfig {
        applicationId = "hu.paulolajos.getcurrentlocation"
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

    // Location
    implementation(libs.play.services.location)

    // Coroutines
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // Fragments
    implementation(libs.androidx.fragment.ktx)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}