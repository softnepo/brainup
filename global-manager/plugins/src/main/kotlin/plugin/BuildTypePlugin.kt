package plugin

import com.android.build.api.dsl.ApplicationDefaultConfig
import com.android.build.api.dsl.CommonExtension

fun CommonExtension<*, *, *, *>.configureBuildType(
    rootDir: String,
    build: ApplicationDefaultConfig,
    name: (String) -> Unit

) {
    buildTypes {
        getByName("debug") {
            name("test.debug")
        }

        getByName("release") {
            name("release")
        }
    }
}