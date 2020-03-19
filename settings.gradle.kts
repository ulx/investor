
rootProject.buildFileName = "build.gradle.kts"
rootProject.name = "Sberinvestor"

include(ModuleDependency.APP, ModuleDependency.LIBRARY_CORE,
    ModuleDependency.FEATURE_LOGIN,
    ModuleDependency.FEATURE_DASHBOARD,
    ModuleDependency.FEATURE_BALANCE,
    ModuleDependency.FEATURE_MARKET,
    ModuleDependency.FEATURE_NEWS,
    ModuleDependency.FEATURE_PROFILE)


pluginManagement {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven (url = "https://maven.fabric.io/public" )
        gradlePluginPortal()
    }
}