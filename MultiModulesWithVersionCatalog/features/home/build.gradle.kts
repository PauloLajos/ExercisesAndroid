import java.util.*

val localProperties = Properties().apply {
    load(rootProject.file(Constants.LOCAL_PROPERTIES).inputStream())
}
val baseUrl: String = localProperties.getProperty(Constants.BASE_URL) ?: Constants.EMPTY_STRING

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android.plugin)
}

android {
    namespace = "hu.paulolajos.home"
    compileSdk = AppConfigs.compileSdk

    defaultConfig {
        minSdk = AppConfigs.minSdk

        testInstrumentationRunner = AppConfigs.testInstrumentationRunner

        buildConfigField(Constants.BASE_URL_TYPE, Constants.BASE_URL, "\"$baseUrl\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(Constants.PROGUARD_ANDROID_OPTIMIZE),
                Constants.PROGUARD_RULES
            )
        }
    }
    compileOptions {
        sourceCompatibility = AppConfigs.javaVersion
        targetCompatibility = AppConfigs.javaVersion
    }
    kotlinOptions {
        jvmTarget = AppConfigs.jvmTarget
    }
    packaging {
        resources {
            excludes += Constants.EXCLUDES
        }
    }
    buildFeatures {
        buildConfig = true
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.legacy.support.v4)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}