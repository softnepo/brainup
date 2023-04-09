plugins {
    id("brainup.app.build")
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

        create("devRelease") {
           // initWith(getByName("release")) <- Verify setting in futuro
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
}

dependencies {

    implementation(libs.androidx.core.ktx)

    implementation(libs.compose.ui)
    implementation(libs.compose.preview)
    implementation(libs.compose.material)
    implementation(libs.compose.activity)

    implementation(libs.lifecycle.runtime)

    testImplementation(libs.test.junit)

    androidTestImplementation(libs.test.android.junit)
    androidTestImplementation(libs.test.android.espresso)
    androidTestImplementation(libs.test.android.compose.ui)
}