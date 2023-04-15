package default

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

internal class AndroidComposeDefault(
    private val project: Project,
    private val extension: CommonExtension<*, *, *, *>
) {

    private val catalog: VersionCatalog = project.extensions.getByType<VersionCatalogsExtension>().named("libs")

    fun init() : Unit {
        extension.apply {
            buildFeatures.compose = true
            composeOptions {
                kotlinCompilerExtensionVersion = catalog.findVersion("compose").get().toString()
            }

            project.dependencies {
                val bom = catalog.findLibrary("androidx-compose-bom").get()
                add("implementation", platform(bom))
                add("androidTestImplementation", platform(bom))
            }
        }
    }
}