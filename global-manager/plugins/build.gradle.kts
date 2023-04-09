plugins { `kotlin-dsl` }

group = "com.lnsantos.brainup.plugins"
version = "0.0.1"

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("top.softnepo:easy-logic:0.0.12-experimental")
    compileOnly(gradleApi())
    implementation("com.android.tools.build:gradle:7.4.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
}

gradlePlugin {
    plugins {
        register("basicBuildConfigPlugin") {
            id = "brainup.module.build"
            implementationClass = "plugin.BasicBuildConfigPlugin"
        }
        register("buildTypePlugin") {
            id = "brainup.build.type"
            implementationClass = "plugin.BuildTypePlugin"
        }
        register("applicationBuildConfigPlugin") {
            id = "brainup.app.build"
            implementationClass = "plugin.ApplicationBuildConfigPlugin"
        }
        register("applicationBuildComposePlugin") {
            id = "brainup.app.compose"
            implementationClass = "plugin.ApplicationBuildComposePlugin"
        }
    }
}