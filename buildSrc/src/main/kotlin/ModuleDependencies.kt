// "Module" means "project" in terminology of Gradle API. To be specific each "Android module" is a Gradle "subproject"
@Suppress("unused")
object ModuleDependency {
    // All consts are accessed via reflection
    const val APP = ":app"


    private const val LIBRARY = ":library"
    const val LIBRARY_CORE = "$LIBRARY:core"


    const val FEATURE_ALBUM = ":feature_album"
    const val FEATURE_PROFILE = ":feature_profile"
    const val FEATURE_FAVOURITE = ":feature_favourite"


    // False positive" function can be private"
    // See: https://youtrack.jetbrains.com/issue/KT-33610
//    fun getAllModules() = ModuleDependency::class.memberProperties
//        .filter { it.isConst }
//        .map { it.getter.call().toString() }
//        .toSet()
//
//    fun getDynamicFeatureModules() = getAllModules()
//        .filter { it.startsWith(FEATURE_PREFIX) }
//        .toSet()
}