package support

import com.android.build.api.dsl.ApkSigningConfig
import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import java.io.File

internal fun Project.getApplicationBuild(
    common: CommonExtension<*, *, *, *>.() -> Unit
) {
    extensions.configure<ApplicationExtension>() {
        common(this)
    }
}

internal fun NamedDomainObjectContainer<out ApkSigningConfig>.applyDefaultSign():ApkSigningConfig {
    create("devRelease") {
        storeFile = File("../dev-release.jks")
        storePassword = "android"
        keyAlias = "android"
        keyPassword = "android"
    }
    return this.getAt("devRelease")
}