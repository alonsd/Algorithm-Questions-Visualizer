buildscript {
    dependencies {
        classpath(libs.gradle)
        classpath(libs.navigation.safe.args.gradle.plugin)
        classpath(libs.kotlin.gradle.plugin)
    }
} // Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.google.devtools.ksp") version "1.9.22-1.0.16"
    id("com.google.dagger.hilt.android") version "2.49" apply false
}
