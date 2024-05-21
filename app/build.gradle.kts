plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetBrainsKotlin)
    alias(libs.plugins.serialization)
}

android {
    namespace = "com.fitless.FitnessX"
    compileSdk = Configs.compileSdk

    defaultConfig {
        applicationId = Configs.defaultConfig.applicationId
        minSdk = Configs.defaultConfig.minSdk
        targetSdk = Configs.defaultConfig.targetSdk
        versionCode = Configs.defaultConfig.versionCode
        versionName = Configs.defaultConfig.versionName
        testInstrumentationRunner = Configs.defaultConfig.testInstrumentationRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = Configs.buildTypes.release.isMinifyEnabled
            proguardFiles(
                file(Configs.buildTypes.release.proguardFiles.androidOptimize),
                file(Configs.buildTypes.release.proguardFiles.customRules)
            )
        }
    }

    compileOptions {
        sourceCompatibility = Configs.compileOptions.sourceCompatibility
        targetCompatibility = Configs.compileOptions.targetCompatibility
    }

    kotlinOptions {
        jvmTarget = Configs.kotlinOptions.jvmTarget
    }

    buildFeatures {
        viewBinding = Configs.buildFeatures.viewBinding
    }

}

dependencies {

    implementation(project(":core"))
    implementation(project(":onboarding"))
    implementation(project(":authorization"))
    implementation(project(":common"))

}