plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("org.jetbrains.kotlin.kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.norkut.orkestapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.norkut.orkestapp"
        minSdk = 24
        targetSdk = 36
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


    // Hilt core
    implementation("com.google.dagger:hilt-android:2.56")

    // Hilt compiler (necesario para que funcione)
    kapt("com.google.dagger:hilt-compiler:2.56")

    // Navegación con Compose (opcional pero útil)
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    // Retrofit (cliente REST)
    implementation("com.squareup.retrofit2:retrofit:2.11.0")

    // Convertidor JSON → Objetos (Gson para Retrofit)
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")

    // OkHttp (cliente HTTP subyacente)
    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    // Interceptor de logging para depuración en Logcat
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}