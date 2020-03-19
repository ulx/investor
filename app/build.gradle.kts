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

    //  // Each feature module that is included in settings.gradle.kts is added here as dynamic feature
    //    dynamicFeatures = ??
}

dependencies {

    api(project(ModuleDependency.LIBRARY_CORE))

    // default dependencies
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    api(LibraryDependency.KOTLIN)
    // androidx support libraries
    implementation("com.google.android.material:material:1.2.0-alpha05")
    implementation("androidx.recyclerview:recyclerview:1.1.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")

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
    api(LibraryDependency.FRAGMENT_TESTING)

    // test base
    addTestDependencies()
}
