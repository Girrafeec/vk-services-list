plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.safeArgs)
}

android {
    compileSdk = 33

    defaultConfig {
        applicationId = "com.girrafeecstud.vk_services_list"
        minSdk = 21
        targetSdk = 32
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    // AppCompat
    implementation(Dependencies.AndroidX.AppCompat.appCompat)

    // Core
    implementation(Dependencies.AndroidX.Core.coreKtx)

    // Unit-tests
    testImplementation(Dependencies.jUnit.jUnit)

    // ConstraintLayout
    implementation(Dependencies.AndroidX.ConstraintLayout.constraintLayout)

    // Google Material
    implementation(Dependencies.Google.Material.material)

    // Dagger
    implementation(Dependencies.Dagger.dagger)
    kapt(Dependencies.Dagger.daggerCompiler)

    // Navigation
    implementation(Dependencies.Jetpack.Navigation.navigationFragmentKtx)
    implementation(Dependencies.Jetpack.Navigation.navigationUiKtx)

    // Retrofit
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.retrofitConverterGson)

    // OkHttp3
    implementation(Dependencies.OkHttp3.okHttp3)

    // ViewModel, LiveData
    implementation(Dependencies.Jetpack.ViewModel.viewModel)
    implementation(Dependencies.Jetpack.LiveData.liveData)

    // Coroutines
    implementation(Dependencies.Coroutines.coroutines)
}