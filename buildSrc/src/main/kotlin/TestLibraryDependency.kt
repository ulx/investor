private object TestLibraryVersion {
    const val JUNIT = "4.13"
    const val TEST_RUNNER = "1.2.0"
    const val TEST_EXT_RUNNER = "1.1.1"
    const val ESPRESSO_CORE = "3.0.2"
    const val MOCKITO = "3.2.4"
    const val MOCKITO_KOTLIN = "2.2.0"
    const val ANDROID_X_TEST = "2.1.0"
    const val ROBOELECTRIC_VERSION = "4.3"
}

object TestLibraryDependency {
    const val JUNIT = "junit:junit:${TestLibraryVersion.JUNIT}"
    const val TEST_EXT_RUNNER = "androidx.test.ext:junit:${TestLibraryVersion.TEST_EXT_RUNNER}"
    const val TEST_RUNNER = "androidx.test:runner:${TestLibraryVersion.TEST_RUNNER}"
    const val ESPRESSO_CORE = "com.android.support.test.espresso:espresso-core:${TestLibraryVersion.ESPRESSO_CORE}"
    const val MOCKITO_INLINE = "org.mockito:mockito-inline:${TestLibraryVersion.MOCKITO}"
    const val MOCKITO_ANDROID = "org.mockito:mockito-android:${TestLibraryVersion.MOCKITO}"
    const val MOCKITO_KOTLIN = "com.nhaarman.mockitokotlin2:mockito-kotlin:${TestLibraryVersion.MOCKITO_KOTLIN}"
    const val COROUTINES_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${CoreVersion.COROUTINES_ANDROID}"
    const val ANDROID_X_CORE_TESTING = "android.arch.core:core-testing:${TestLibraryVersion.ANDROID_X_TEST}"
    const val ROBOELECTRIC = "org.robolectric:robolectric:${TestLibraryVersion.ROBOELECTRIC_VERSION}"
}


