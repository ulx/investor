@file:Suppress("detekt.StringLiteralDuplication")

private object LibraryVersion {
    const val RETROFIT = "2.7.1"
    const val OK_HTTP = "4.3.1"
    const val PLAY_CORE = "1.6.4"
    const val APP_COMPACT = "1.1.0"
    const val RECYCLER_VIEW = "1.1.0"
    const val COORDINATOR_LAYOUT = "1.1.0"

    // 1.1.x version is required in order to support the dark theme functionality in
    // Android Q (adds Theme.MaterialComponents.DayNight)
    const val MATERIAL = "1.1.0"
    const val CONSTRAINT_LAYOUT = "1.1.3"
    const val CORE_KTX = "1.2.0"
    const val FRAGMENT_KTX = "1.2.3"
    const val LIFECYCLE = "2.2.0"
    const val COIL = "0.9.1"
    const val KOIN_VERSION = "2.1.4"
}

object LibraryDependency {
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${CoreVersion.KOTLIN}"

    // Required by Android dynamic feature modules and SafeArgs
    const val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect:${CoreVersion.KOTLIN}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${LibraryVersion.RETROFIT}"

    // Retrofit will use okhttp 4 (it tas binary capability with okhttp 3)
    // See: https://square.github.io/okhttp/upgrading_to_okhttp_4/
    const val OK_HTTP = "com.squareup.okhttp3:okhttp:${LibraryVersion.OK_HTTP}"
    const val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${LibraryVersion.OK_HTTP}"

    // UI
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${LibraryVersion.CONSTRAINT_LAYOUT}"
    const val APP_COMPACT = "androidx.appcompat:appcompat:${LibraryVersion.APP_COMPACT}"
    const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:${LibraryVersion.RECYCLER_VIEW}"
    const val COORDINATOR_LAYOUT = "androidx.coordinatorlayout:coordinatorlayout:${LibraryVersion.COORDINATOR_LAYOUT}"
    const val MATERIAL = "com.google.android.material:material:${LibraryVersion.MATERIAL}"

    const val PLAY_CORE = "com.google.android.play:core:${LibraryVersion.PLAY_CORE}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${CoreVersion.COROUTINES_ANDROID}"
    const val CORE_KTX = "androidx.core:core-ktx:${LibraryVersion.CORE_KTX}"

    // navigation
    const val NAVIGATION_FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:${CoreVersion.NAVIGATION}"
    const val NAVIGATION_UI_KTX = "androidx.navigation:navigation-ui-ktx:${CoreVersion.NAVIGATION}"

    // image loader
    const val COIL = "io.coil-kt:coil:${LibraryVersion.COIL}"

    // lifecycleVersion
    const val LIFECYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-extensions:${LibraryVersion.LIFECYCLE}"
    const val LIFECYCLE_VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${LibraryVersion.LIFECYCLE}"
    const val LIFECYCLE_RUNTIME_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:${LibraryVersion.LIFECYCLE}"
    const val LIFECYCLE_LIVEDATA_KTX = "androidx.lifecycle:lifecycle-livedata-ktx:${LibraryVersion.LIFECYCLE}"
    const val LIFECYCLE_VIEWMODEL_SAVEDSTATE = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${LibraryVersion.LIFECYCLE}"

    // fragment
    const val FRAGMENT = "androidx.fragment:fragment:${LibraryVersion.FRAGMENT_KTX}"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${LibraryVersion.FRAGMENT_KTX}"
    const val FRAGMENT_TESTING = "androidx.fragment:fragment-testing:${LibraryVersion.FRAGMENT_KTX}"

    // koin
    const val KOIN_CORE = "org.koin:koin-core:${LibraryVersion.KOIN_VERSION}"
    const val KOIN_TEST = "org.koin:koin-test:${LibraryVersion.KOIN_VERSION}"
    const val KOIN_ANDROIDX_SCOPE = "org.koin:koin-androidx-scope:${LibraryVersion.KOIN_VERSION}"
    const val KOIN_ANDROIDX_VIEW_MODEL = "org.koin:koin-androidx-viewmodel:${LibraryVersion.KOIN_VERSION}"
    const val KOIN_ANDROIDX_FRAGMENT = "org.koin:koin-androidx-fragment:${LibraryVersion.KOIN_VERSION}"
}

