

//include(ModuleDependency.APP,
//    ModuleDependency.LIBRARY_SIMPLE,
//    ModuleDependency.LIBRARY_CORE,
//    ModuleDependency.LIBRARY_STORAGE,
//    ModuleDependency.LIBRARY_NETWORK,
//    ModuleDependency.FEATURE_SIMPLE,
//    ModuleDependency.FEATURE_LOGIN,
//    ModuleDependency.FEATURE_DASHBOARD)
val library = ":library"
val feature = ":feature"
include(":app",
    "$library:simple",
    "$library:core",
    "$library:network",
    "$library:designlib",
    "$library:storage",
    "$feature:simplefeature",
    "$feature:login",
    "$feature:dashboard",
    "$feature:uitests"
)

pluginManagement {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven (url = "https://maven.fabric.io/public" )
        gradlePluginPortal()
    }
}

rootProject.buildFileName = "build.gradle.kts"
rootProject.name = "Sberinvestor"

//include(*(ModuleDependency.getAllModules.toTypedArray()))


