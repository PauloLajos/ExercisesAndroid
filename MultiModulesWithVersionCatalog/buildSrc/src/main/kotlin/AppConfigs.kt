import org.gradle.api.JavaVersion

object AppConfigs {
    const val namespace = "hu.paulolajos.multimoduleswithversioncatalog"
    const val applicationId = "hu.paulolajos.multimoduleswithversioncatalog"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    const val compileSdk = 34
    const val minSdk = 24
    const val targetSdk = 34
    const val versionCode = 1
    const val versionName = "1.0"

    val javaVersion = JavaVersion.VERSION_17
    const val jvmTarget = "17"

    const val kotlinCompilerExtensionVersion = "1.4.3"
}