plugins {
    id("brainup.app.build")
    id("brainup.build.type")
}

android {
    defaultConfig.vectorDrawables.useSupportLibrary = true
    namespace = "com.lnsantos.brainup.pet"
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.lifecycle.runtime)

    implementation(libs.androidx.compose.activity)
    implementation(project(":pet"))

    testImplementation(libs.test.junit)

    androidTestImplementation(libs.test.android.junit)
    androidTestImplementation(libs.test.android.espresso)
    androidTestImplementation(libs.test.android.compose.ui)
}