pluginManagement {
    includeBuild("global-manager")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
enableFeaturePreview("VERSION_CATALOGS")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }

    versionCatalogs.create("libs") { from(files("references.toml")) }
}

rootProject.name = "Brain up"
include(":app")
include(":pet")
include(":pet-preview")
