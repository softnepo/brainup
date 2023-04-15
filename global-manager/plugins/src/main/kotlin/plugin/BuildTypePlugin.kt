package plugin

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.InvalidUserDataException
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.UnknownDomainObjectException
import support.getBuildProject

class BuildTypePlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {

        try {
            getBuildProject<LibraryExtension> {
                configureBuildType { println(">BuildTypePlugin : BuildType find $it") }
            }
        } catch (e : UnknownDomainObjectException) {
            getBuildProject<ApplicationExtension> {
                configureBuildType { println(">BuildTypePlugin : BuildType find $it") }
            }
        }

    }
}

fun CommonExtension<*, *, *, *>.configureBuildType(name: (String) -> Unit) {
    buildTypes {
        getByName("debug") {
            name("test.debug")
        }

        getByName("release") {
            name("release")
        }

        try {
            create("devRelease") {
                name("dev.release")
            }
        } catch (e: InvalidUserDataException) {
            getByName("devRelease") {
                name("dev.release")
            }
        }
    }
}