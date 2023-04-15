package plugin

import com.android.build.api.dsl.CommonExtension

fun CommonExtension<*, *, *, *>.configureBuildType(name: (String) -> Unit) {
    buildTypes {
        getByName("debug") {
            name("test.debug")
        }

        getByName("release") {
            name("release")
        }
    }
}