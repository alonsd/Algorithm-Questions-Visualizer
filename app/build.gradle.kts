@file:Suppress("UnstableApiUsage")

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
    compileSdk = 33
    buildFeatures {
        viewBinding = true
        dataBinding = true
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }


    defaultConfig {
        applicationId = "com.alqoview"
        minSdk = 24
        targetSdk = 33
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

    //Used for compose navigation code generator
    applicationVariants.all {
        addJavaSourceFoldersToModel(
            File(buildDir, "generated/ksp/$name/kotlin")
        )
        // There is currently an issue with the below solution:
        // https://issuetracker.google.com/issues/255915317
        // For now we use the solution above until ramcosta solves it ☝️

//        kotlin.sourceSets {
//            getByName(name) {
//                kotlin.srcDir("build/generated/ksp/$name/kotlin")
//            }
//        }
    }

    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }

}

dependencies {
    //AppCompat
    implementation("androidx.appcompat:appcompat:1.6.0")

    //System UI
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.28.0")

    //Compose
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("androidx.compose.animation:animation:1.4.0-alpha05")
    implementation("androidx.compose.ui:ui-tooling:1.4.0-alpha05")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.4.0-alpha05")
    implementation("com.google.accompanist:accompanist-pager:0.28.0")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.28.0")

    //Coil
    implementation("io.coil-kt:coil-compose:2.2.2")

    //Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    testImplementation("com.google.truth:truth:1.1.3")

    //Kotlin
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    //Ok Http Logging
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.7")

    //NetworkResponseAdapter
    implementation("com.github.haroldadmin:NetworkResponseAdapter:4.2.1")

    // Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")

    //Material
    implementation("androidx.compose.material3:material3:1.0.1")

    //Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")

    //Gson
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //Dagger - Hilt
    implementation("com.google.dagger:hilt-android:2.44.2")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    kapt("com.google.dagger:hilt-compiler:2.44.2")

    //Compose Destinations
    implementation("io.github.raamcosta.compose-destinations:animations-core:1.8.33-beta")
    ksp("io.github.raamcosta.compose-destinations:ksp:1.8.33-beta")

}

kapt {
    generateStubs = true
}
