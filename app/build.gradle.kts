import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id(GradlePluginId.ANDROID_APPLICATION)
    id(GradlePluginId.GOOGLE_SERVICE)
    kotlin(GradlePluginId.KOTLIN_ANDROID)
    kotlin(GradlePluginId.KOTLIN_ANDROID_EXTENSIONS)
    kotlin(GradlePluginId.KOTLIN_KAPT)
    id(GradlePluginId.FABRIC)
    id(GradlePluginId.SAFE_ARGS)
    id(GradlePluginId.KTLINT_GRADLE)
    id(GradlePluginId.KOIN)
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        applicationId = AndroidConfig.ID
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)
        buildToolsVersion(AndroidConfig.BUILD_TOOLS_VERSION)

        versionCode = AndroidConfig.VERSION_CODE
        versionName = AndroidConfig.VERSION_NAME
        testInstrumentationRunner = AndroidConfig.TEST_INSTRUMENTATION_RUNNER
    }

    viewBinding.isEnabled = true

    signingConfigs {
//        create("play") {
//            storeFile = rootProject.file("")
//            storePassword = ""
//            keyAlias = ""
//            keyPassword = ""
//        }
    }
    buildTypes {
        getByName(BuildType.RELEASE) {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            proguardFiles("proguard-android.txt", "proguard-rules.pro")
        }

        getByName(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
        }

        testOptions {
            unitTests.isReturnDefaultValues = TestOptions.IS_RETURN_DEFAULT_VALUES
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
    }

    lintOptions {
        // By default lint does not check test sources, but setting this option means that lint will not even parse them
        isIgnoreTestSources = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    dynamicFeatures = ModuleDependency.getDynamicFeatureModules().toMutableSet()
}

dependencies {

    api(project(ModuleDependency.LIBRARY_CORE))

    // default dependencies
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    api(LibraryDependency.KOTLIN)
    implementation(LibraryDependency.PLAY_CORE)

    // androidx support libraries
    api(LibraryDependency.MATERIAL)
    api(LibraryDependency.RECYCLER_VIEW)
    api(LibraryDependency.CONSTRAINT_LAYOUT)

    api(LibraryDependency.CORE_KTX)
    api(LibraryDependency.APP_COMPACT)

    api(LibraryDependency.LIFECYCLE_EXTENSIONS)
    api(LibraryDependency.LIFECYCLE_VIEWMODEL_KTX)
    api(LibraryDependency.LIFECYCLE_RUNTIME_KTX)
    api(LibraryDependency.LIFECYCLE_LIVEDATA_KTX)
    api(LibraryDependency.LIFECYCLE_VIEWMODEL_SAVEDSTATE)

    api(LibraryDependency.NAVIGATION_FRAGMENT_KTX)
    api(LibraryDependency.NAVIGATION_UI_KTX)

    // fragment
    api(LibraryDependency.FRAGMENT)
    api(LibraryDependency.FRAGMENT_KTX)

    // koin
    api(LibraryDependency.KOIN_ANDROID)
    api(LibraryDependency.KOIN_ANDROIDX_FRAGMENT)
    api(LibraryDependency.KOIN_ANDROIDX_SCOPE)
    api(LibraryDependency.KOIN_ANDROIDX_VIEW_MODEL)

    // test base
    addTestDependencies()
}
