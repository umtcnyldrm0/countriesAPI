plugins {
    alias(libs.plugins.androidApplication)
    id("androidx.navigation.safeargs")
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.pulsetech.myapplication"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.pulsetech.myapplication"
        minSdk = 28
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

            buildFeatures {
                viewBinding = true
                dataBinding = true
            }


        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    dependencies {

        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.appcompat)
        implementation(libs.material)
        implementation(libs.androidx.activity)
        implementation(libs.androidx.constraintlayout)
        implementation(libs.androidx.swiperefreshlayout)
        implementation(libs.androidx.navigation.fragment.ktx)
        implementation(libs.androidx.navigation.ui.ktx)
        implementation(libs.androidx.lifecycle.viewmodel.android)
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)





        implementation("androidx.fragment:fragment-ktx:1.6.1")
        implementation("androidx.navigation:navigation-fragment-ktx:2.7.4")
        implementation("androidx.navigation:navigation-ui-ktx:2.7.4")


        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.squareup.retrofit2:converter-gson:2.9.0")


        implementation("io.reactivex.rxjava3:rxjava:3.1.7")
        implementation("io.reactivex.rxjava3:rxandroid:3.0.2")







        implementation("io.reactivex.rxjava3:rxjava:3.1.0")
        implementation("io.reactivex.rxjava3:rxandroid:3.0.0")
        implementation("com.squareup.retrofit2:adapter-rxjava3:2.9.0")


    }


}

