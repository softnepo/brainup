package plugin.application


import com.android.build.api.dsl.ApplicationExtension
import default.AndroidComposeDefault
import default.plugin.ApplicationPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType
import support.getBuildProject

class ApplicationBuildComposePlugin : ApplicationPlugin()  {
    override fun onSettings(project: Project, extension: ApplicationExtension) {
        AndroidComposeDefault(project = project, extension = extension).init()
    }
}