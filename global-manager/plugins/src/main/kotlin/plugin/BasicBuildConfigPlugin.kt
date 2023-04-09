package plugin

import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import top.softnepo.public.easyLogicBuild
import top.softnepo.public.easyLogicPlugins
import java.io.File

class BasicBuildConfigPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        easyLogicPlugins {
            applyPlugin("com.android.library")
        }
        easyLogicBuild {
            compileSdk = DefaultConfigBuild.SDK_TARGET
            targetSdk = DefaultConfigBuild.SDK_TARGET

            onDefaultConfig {
                this@onDefaultConfig.minSdk = DefaultConfigBuild.SDK_MIN
                this@onDefaultConfig.testInstrumentationRunner =
                    "androidx.test.runner.AndroidJUnitRunner"
                this@onDefaultConfig.setProguardFiles(
                    listOf(
                        File(target.rootDir, "brainup-proguard-rules.pro").path
                    )
                )
            }
            onCompileOptions {
                this@onCompileOptions.sourceCompatibility = JavaVersion.VERSION_11
                this@onCompileOptions.targetCompatibility = JavaVersion.VERSION_11
            }
        }
    }
}