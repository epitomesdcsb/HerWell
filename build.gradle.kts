plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.food"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.food"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.activity)
    implementation (libs.google.material)
    implementation (libs.picasso)



    //   implementation (libs.openai) // OpenAI SDK
    implementation (libs.recyclerview) // RecyclerView
    implementation (libs.room.runtime) // Room Database
    annotationProcessor (libs.room.compiler )
    // implementation (libs.lifecycle.viewmodel.ktx)
    // implementation (libs.material.v180) // Material Design
    // implementation (libs.kotlinx.coroutines.android )// Coroutines
    implementation (libs.retrofit)
    {
        exclude("okhttp")
    }
    // Retrofit
    implementation (libs.converter.gson) // JSON Converter
    implementation (libs.logging.interceptor)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}