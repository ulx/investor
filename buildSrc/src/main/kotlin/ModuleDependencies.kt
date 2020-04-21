// "Module" means "project" in terminology of Gradle API. To be specific each "Android module" is a Gradle "subproject"
@Suppress("unused")
object ModuleDependency {
    // All consts are accessed via reflection
    const val APP = ":app"


    private const val LIBRARY = ":library"
    const val LIBRARY_SIMPLE = "$LIBRARY:simple"
    const val LIBRARY_CORE = "$LIBRARY:core"
    const val LIBRARY_STORAGE = "$LIBRARY:storage"
    const val LIBRARY_NETWORK = "$LIBRARY:network"
    const val LIBRARY_DESIGN = "$LIBRARY:designlib"

    private const val FEATURE = ":feature"
    const val FEATURE_SIMPLE = "$FEATURE:simplefeature"
    const val FEATURE_LOGIN = "$FEATURE:login"
    const val FEATURE_DASHBOARD = "$FEATURE:dashboard"
    const val FEATURE_UITESTS = "$FEATURE:uitests"
//    const val FEATURE_BALANCE = "$FEATURE:balance"
//    const val FEATURE_MARKET = "$FEATURE:market"
//    const val FEATURE_NEWS = "$FEATURE:news"
//    const val FEATURE_PROFILE = "$FEATURE:profile"

     val getAllModules = setOf(
        APP,
        LIBRARY_SIMPLE,
        LIBRARY_CORE,
        LIBRARY_STORAGE,
        LIBRARY_NETWORK,
         LIBRARY_DESIGN,
        FEATURE_SIMPLE,
        FEATURE_LOGIN,
        FEATURE_DASHBOARD,
         FEATURE_UITESTS)

    fun getDynamicFeatureModules() = getAllModules
        .filter { it.startsWith(FEATURE) }
        .toSet()
}