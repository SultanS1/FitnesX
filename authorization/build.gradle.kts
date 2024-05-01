plugins {
    alias(libs.plugins.library)
    alias(libs.plugins.jetBrainsKotlin)
}

android {
    namespace = "com.fitless.authorization"
    compileSdk = Configs.compileSdk

    defaultConfig {
        minSdk = Configs.defaultConfig.minSdk
        testInstrumentationRunner = Configs.defaultConfig.testInstrumentationRunner
        consumerProguardFiles(file(Configs.defaultConfig.consumerProguardFiles))
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

    implementation(project(":common"))

}