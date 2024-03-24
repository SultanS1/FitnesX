plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetBrainsKotlin)
}

android {
    namespace = "com.fitless.FitnessX"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.fitless.FitnessX"
        minSdk = 24
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

    buildFeatures{
        viewBinding = true
    }

}

dependencies {

    implementation(project(":core"))
    implementation(project(":onboarding"))
    implementation(project(":common"))

    implementation (libs.koin.core)
    implementation (libs.koin.android)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //viewBindingDelegate
    implementation(libs.viewBindingDelegate)

    implementation(libs.cicerone)

}