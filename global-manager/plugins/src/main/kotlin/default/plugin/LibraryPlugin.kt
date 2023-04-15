package default.plugin

import com.android.build.api.dsl.LibraryExtension
import default.plugin.DelegatePlugin.Companion.getInfoProject
import org.gradle.api.Project

abstract class LibraryPlugin : DelegatePlugin<LibraryExtension> {
    override fun apply(target: Project) = with(target) {
        getInfoProject<LibraryExtension> { onSettings(target, this as LibraryExtension) }
    }
}