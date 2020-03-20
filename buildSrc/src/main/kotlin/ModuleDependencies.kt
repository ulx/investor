// "Module" means "project" in terminology of Gradle API. To be specific each "Android module" is a Gradle "subproject"
@Suppress("unused")
object ModuleDependency {
    // All consts are accessed via reflection
    const val APP = ":app"


    private const val LIBRARY = ":library"
    const val LIBRARY_CORE = "$LIBRARY:core"

    private const val FEATURE = ":feature"
    const val FEATURE_LOGIN = "$FEATURE:login"
    const val FEATURE_DASHBOARD = "$FEATURE:dashboard"
//    const val FEATURE_BALANCE = "$FEATURE:balance"
//    const val FEATURE_MARKET = "$FEATURE:market"
//    const val FEATURE_NEWS = "$FEATURE:news"
//    const val FEATURE_PROFILE = "$FEATURE:profile"


    fun getAllModules() = setOf(APP, LIBRARY_CORE, FEATURE_LOGIN, FEATURE_DASHBOARD)

    fun getDynamicFeatureModules() = getAllModules()
        .filter { it.startsWith(FEATURE) }
        .toSet()
}