plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.gradlePlugin)
    alias(libs.plugins.firebase.crashlytics)
    alias(libs.plugins.hilt)
    alias(libs.plugins.secrets)
}

android {
    namespace = "com.finger.Android"
    compileSdk = 33
    buildToolsVersion = "31.0.0"

    defaultConfig {
        applicationId = "com.finger.Android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), file("proguard-rules.pro"))
        }
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), file("proguard-rules.pro"))
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
        viewBinding =true
    }
}

dependencies {
    implementation (libs.androidx.core)
    implementation (libs.androidx.appcompat)
    implementation (libs.androidx.constraintlayout)

    implementation (libs.bundles.lifecycle)
    implementation (libs.bundles.compose)

    implementation(libs.hilt.plugin)

    implementation(libs.firebase.analytics)
    implementation(libs.firebase.cloud.messaging)
    implementation(libs.firebase.crashlytics)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso)


    implementation(project(":feature:interests"))
    implementation(project(":feature:foryou"))
    implementation(project(":feature:bookmarks"))
    implementation(project(":feature:topic"))
    implementation(project(":feature:search"))
    implementation(project(":feature:settings"))

    implementation(project(":core:common"))
    implementation(project(":core:ui"))
    implementation(project(":core:designsystem"))
    implementation(project(":core:data"))
    implementation(project(":core:model"))
    implementation(project(":core:analytics"))

    implementation(project(":sync:work"))

    androidTestImplementation(project(":core:testing"))
    androidTestImplementation(project(":core:datastore-test"))
    androidTestImplementation(project(":core:data-test"))
    androidTestImplementation(project(":core:network"))
    androidTestImplementation(libs.androidx.navigation.testing)
    androidTestImplementation(libs.accompanist.testharness)
    androidTestImplementation(kotlin("test"))
    debugImplementation(libs.androidx.compose.ui.testManifest)
    debugImplementation(project(":ui-test-hilt-manifest"))

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.compose.runtime.tracing)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.window.manager)
    implementation(libs.androidx.profileinstaller)
    implementation(libs.kotlinx.coroutines.guava)
    implementation(libs.coil.kt)
}

// androidx.test is forcing JUnit, 4.12. This forces it to use 4.13
configurations.configureEach {
    resolutionStrategy {
        force(libs.junit4)
        // Temporary workaround for https://issuetracker.google.com/174733673
        force("org.objenesis:objenesis:2.6")
    }
}
