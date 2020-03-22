
rootProject.buildFileName = "build.gradle.kts"
rootProject.name = "Sberinvestor"

include(ModuleDependency.APP,
    ModuleDependency.LIBRARY_SIMPLE,
    ModuleDependency.LIBRARY_CORE,
    ModuleDependency.FEATURE_SIMPLE,
    ModuleDependency.FEATURE_LOGIN,
    ModuleDependency.FEATURE_DASHBOARD)


pluginManagement {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven (url = "https://maven.fabric.io/public" )
        gradlePluginPortal()
    }
}