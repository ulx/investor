object AndroidConfig {
    const val COMPILE_SDK_VERSION = 29
    const val MIN_SDK_VERSION = 23
    const val TARGET_SDK_VERSION = 29
    const val BUILD_TOOLS_VERSION = "29.0.1"

    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0"

    const val ID = "ru.sberbank.sberinvestor"
    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.ext.junit.runners.AndroidJUnit4"
}

interface BuildType {

    companion object {
        const val RELEASE = "release"
        const val DEBUG = "debug"
    }

    val isMinifyEnabled: Boolean
}

object BuildTypeDebug : BuildType {
    override val isMinifyEnabled = false
}

object BuildTypeRelease : BuildType {
    override val isMinifyEnabled = false
}

object TestOptions {
    const val IS_RETURN_DEFAULT_VALUES = true
}