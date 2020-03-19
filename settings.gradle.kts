rootProject.buildFileName = "build.gradle.kts"
rootProject.name = "Sberinvestor"

include(":app", ModuleDependency.LIBRARY_CORE, ModuleDependency.FEATURE_LOGIN)


pluginManagement {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven (url = "https://maven.fabric.io/public" )
        gradlePluginPortal()
    }
}