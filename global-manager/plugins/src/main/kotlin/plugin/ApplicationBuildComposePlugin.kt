package plugin

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType
import support.getApplicationBuild

class ApplicationBuildComposePlugin : Plugin<Project>  {
    override fun apply(target: Project) = with(target) {
        val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

        getApplicationBuild {
            buildFeatures.compose = true
            composeOptions {
                kotlinCompilerExtensionVersion = libs.findVersion("compose").get().toString()
            }
        }
    }
}