enableFeaturePreview("VERSION_CATALOGS")
dependencyResolutionManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    versionCatalogs.create("libs") { from(files("../references.toml")) }
}

rootProject.name = "Global Manager"
include( ":references", ":plugins")