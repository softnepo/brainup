package default.plugin

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal interface DelegatePlugin<T> : Plugin<Project> {
    fun onSettings(
        project: Project,
        extension: T
    )

    companion object {
        inline fun <reified T : CommonExtension<*, *, *, *>> Project.getInfoProject(
            crossinline common: CommonExtension<*, *, *, *>.() -> Unit
        ) {
            extensions.configure<T>() {
                common(this)
            }
        }
    }
}