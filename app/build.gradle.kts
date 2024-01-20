plugins {
    kotlin("android")
    kotlin("kapt")
    id("com.android.application")
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs")
    id("com.google.devtools.ksp")
    id("dagger.hilt.android.plugin")
}


android {
    compileSdk = 34
    buildFeatures {
        viewBinding = true
        dataBinding = true
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(17)
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }


    defaultConfig {
        applicationId = "com.alqoview"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        signingConfig = signingConfigs.getByName("debug")
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("debug")
        }

        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    androidComponents {
        onVariants(selector().withBuildType("release")) {
            it.packaging.resources.excludes.add("META-INF/**")
        }
    }
    namespace = "com.alqoview"

}

dependencies {
    //AppCompat
    implementation(libs.appcompat)

    //System UI
    implementation(libs.accompanist.systemuicontroller)

    //Window
    implementation(libs.window)

    //Compose
    implementation(libs.ui)
    implementation(libs.activity.compose)
    implementation(libs.animation)
    implementation(libs.ui.tooling)
    implementation(libs.lifecycle.viewmodel.compose)
    androidTestImplementation(libs.ui.test.junit4)
    implementation(libs.google.accompanist.pager)
    implementation(libs.google.accompanist.pager.indicators)
    implementation(libs.lifecycle.runtime.compose)

    //Coil
    implementation(libs.coil.compose)

    //Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    testImplementation(libs.truth)

    //Kotlin
    implementation(libs.core.ktx)
    implementation(libs.kotlinx.coroutines.core)

    //Ok Http Logging
    implementation(libs.logging.interceptor)

    //NetworkResponseAdapter
    implementation(libs.networkResponseAdapter)

    // Navigation
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui.ktx)

    //Material
    implementation(libs.material3)

    //Coroutines
    implementation(libs.jetbrains.kotlinx.coroutines.android)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    //Gson
    implementation(libs.gson)
    implementation(libs.converter.gson)

    //Dagger - Hilt
    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    kapt(libs.dagger.hilt.compiler)

    //Compose Destinations
    implementation(libs.animations.core)
    ksp(libs.ksp)

}

kapt {
    generateStubs = true
}
