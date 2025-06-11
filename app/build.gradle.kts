plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id ("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id ("kotlin-parcelize")
}

android {
    namespace = "com.example.giphytetsapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.giphytetsapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"https://api.giphy.com\"")
            buildConfigField ("String", "API_KEY", "\"${project.properties["API_KEY"]}\"")

        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"https://api.giphy.com\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation (libs.converter.gson)
    implementation (libs.retrofit2)

    // Compose dependencies
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.9.0")
    implementation ("androidx.compose.material:material-icons-extended:1.7.8")
    implementation ("androidx.activity:activity-compose:1.6.0-alpha01")
    implementation ("com.google.accompanist:accompanist-swiperefresh:0.24.2-alpha")
    implementation("androidx.navigation:navigation-compose:2.9.0")

    //dagger-hilt
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")
    kapt ("androidx.hilt:hilt-compiler:1.2.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    // okhttp
    implementation ("com.squareup.okhttp3:okhttp:5.0.0-alpha.3")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.3")
    implementation("com.google.code.gson:gson:2.10.1")

    //pagination
    implementation("androidx.paging:paging-runtime:3.3.2")
    implementation("androidx.paging:paging-compose:3.3.2")

    //coil
    implementation("io.coil-kt:coil-compose:2.1.0")
}