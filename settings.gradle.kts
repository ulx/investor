rootProject.buildFileName = "build.gradle.kts"
rootProject.name = "Sberinvestor"

include(":app", ModuleDependency.LIBRARY_CORE)


pluginManagement {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven (url = "https://maven.fabric.io/public" )
        gradlePluginPortal()
    }
}