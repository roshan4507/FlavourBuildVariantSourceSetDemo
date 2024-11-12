plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.vicks.fbs"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.vicks.fbs"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    flavorDimensions += listOf("default")

    productFlavors {
        create("free") {
            applicationIdSuffix = ".free"
            versionNameSuffix = "-free"
            buildConfigField("String", "BASE_URL", "\"https://free.example.com\"")
        }

        create("paid") {
            applicationIdSuffix = ".paid"
            versionNameSuffix = "-paid"
            buildConfigField("String", "BASE_URL", "\"https://paid.example.com\"")
        }

        /*create("minAPI31"){
            dimension = "api"
            minSdk = 31
            applicationIdSuffix = ".minAPI31"
            versionNameSuffix = "-minAPI31"
        }*/
    }


    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

        }
        debug {
            isMinifyEnabled = false
            isDebuggable = true

        }
        create("staging") {
            isMinifyEnabled = false
            isDebuggable = true

        }
    }

    /*sourceSets{
        create("free"){
            java {
                srcDirs()
            }
            res {
                srcDirs("res/free/res")
            }
        }

        create("paid"){
            java {
                srcDirs()
            }
            res {
                srcDirs("res/paid/res")
            }
        }
    }*/

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    viewBinding {
        enable = true
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}