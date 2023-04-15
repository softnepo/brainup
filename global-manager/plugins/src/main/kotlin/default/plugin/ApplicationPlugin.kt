package default.plugin

import com.android.build.api.dsl.ApplicationExtension
import default.plugin.DelegatePlugin.Companion.getInfoProject
import org.gradle.api.Project

abstract class ApplicationPlugin : DelegatePlugin<ApplicationExtension> {
    override fun apply(target: Project) = with(target) {
        getInfoProject<ApplicationExtension> { onSettings(target, this as ApplicationExtension) }
    }
}