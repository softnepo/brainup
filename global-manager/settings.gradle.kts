enableFeaturePreview("VERSION_CATALOGS")
dependencyResolutionManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    versionCatalogs.create("libs") { from(files("../references.toml")) }
}

buildCache {
    local {
        directory = File(rootDir, "build-cache")
        removeUnusedEntriesAfterDays = 30
    }
}

rootProject.name = "global-manager"
include( ":references", ":plugins")