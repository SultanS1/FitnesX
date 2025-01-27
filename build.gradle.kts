// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript{
    dependencies {
        classpath(libs.kotlin.serialization)
    }
}
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetBrainsKotlin) apply false
    alias(libs.plugins.library) apply false
    alias(libs.plugins.serialization) apply false
}
