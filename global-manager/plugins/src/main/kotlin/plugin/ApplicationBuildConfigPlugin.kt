package plugin

import com.android.build.api.dsl.ApplicationBaseFlavor
import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import support.getApplicationBuild
import top.softnepo.public.easyLogicPlugins
import java.io.File
import java.util.*

class ApplicationBuildConfigPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        easyLogicPlugins {
            applyPlugin("com.android.application")
            applyPlugin("org.jetbrains.kotlin.android")
            applyPlugin("brainup.app.compose")
        }

        val properties = Properties()
        properties.load(file(rootDir.path + "/version.properties").inputStream())

        val version : String = properties.getProperty("brainup.version")

        getApplicationBuild {
            (this as BaseAppModuleExtension)
            compileSdk = DefaultConfigBuild.SDK_TARGET

            defaultConfig {
                applicationId = "com.lnsantos.brainup"
                minSdk = DefaultConfigBuild.SDK_MIN
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                setProguardFiles(listOf(File(target.rootDir, "brainup-proguard-rules.pro").path))

                configureBuildType {
                    (this as ApplicationBaseFlavor).apply {
                        targetSdk = DefaultConfigBuild.SDK_TARGET
                        versionCode = version.replace(".","").toInt()
                        versionName = "${version}-${it}.${Date().time}"
                    }
                }
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_11
                targetCompatibility = JavaVersion.VERSION_11
            }

            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_11.toString()
            }
        }
    }
}

fun CommonExtension<*, *, *, *>.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
    (this as ExtensionAware).extensions.configure("kotlinOptions", block)
}