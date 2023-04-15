package support

import com.android.build.api.dsl.ApkSigningConfig
import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import java.io.File

inline fun <reified T : CommonExtension<*, *, *, *>> Project.getBuildProject(
    crossinline common: CommonExtension<*, *, *, *>.() -> Unit
) {
    extensions.configure<T>() {
        common(this)
    }
}

internal fun NamedDomainObjectContainer<out ApkSigningConfig>.applyDefaultSign(): ApkSigningConfig {
    create("devRelease") {
        storeFile = File("../dev-release.jks")
        storePassword = "android"
        keyAlias = "android"
        keyPassword = "android"
    }
    return this.getAt("devRelease")
}