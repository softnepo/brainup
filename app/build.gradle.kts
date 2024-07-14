plugins {
    id("brainup.app.build")
    id("brainup.build.type")
    id("kotlin-kapt")
    alias(libs.plugins.hilt)
}

android {

    defaultConfig.vectorDrawables.useSupportLibrary = true

    buildTypes.apply {
        getByName("debug") {
            isMinifyEnabled = false
            applicationIdSuffix = ".debug"
        }

        getByName("release") {
            isMinifyEnabled = true
            applicationIdSuffix = ".final"
            proguardFiles(File(rootDir, "brainup-proguard-rules.pro").path)
            signingConfig = signingConfigs.getByName("debug")
        }

        getByName("devRelease") {
           // initWith(getByName("release")) <- Verify setting in future
            isMinifyEnabled = true
            applicationIdSuffix = ".test"
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    kapt {
        correctErrorTypes = true
        useBuildCache = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.lifecycle.runtime)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.activity)
    implementation(project(":pet"))

    implementation(libs.dagger.hilt.android)
    kapt(libs.dagger.hilt.compiler)

    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.runtime)
    kapt(libs.androidx.room.compiler)

    implementation(libs.androidx.navigation.ui)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.compose)

    testImplementation(libs.test.junit)

    androidTestImplementation(libs.test.android.junit)
    androidTestImplementation(libs.test.android.espresso)
    androidTestImplementation(libs.test.android.compose.ui)
}