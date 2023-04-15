package plugin.library

import com.android.build.api.dsl.LibraryExtension
import default.AndroidComposeDefault
import default.plugin.LibraryPlugin
import org.gradle.api.Project


class LibraryBuildComposePlugin : LibraryPlugin() {
    override fun onSettings(
        project: Project,
        extension: LibraryExtension
    ) {
        AndroidComposeDefault(project = project, extension = extension).init()
    }
}
