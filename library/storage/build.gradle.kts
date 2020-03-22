plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    kotlin(GradlePluginId.KOTLIN_ANDROID)
    kotlin(GradlePluginId.KOTLIN_ANDROID_EXTENSIONS)
    kotlin(GradlePluginId.KOTLIN_KAPT)
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)

        versionCode = AndroidConfig.VERSION_CODE
        versionName = AndroidConfig.VERSION_NAME
        testInstrumentationRunner = AndroidConfig.TEST_INSTRUMENTATION_RUNNER

        javaCompileOptions {
            annotationProcessorOptions {
                arguments = mapOf(
                    "room.schemaLocation" to "$projectDir/schemas".toString(),
                    "room.incremental" to "true",
                    "room.expandProjection" to "true"
                )
            }
        }
    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            proguardFiles("proguard-android.txt", "proguard-rules.pro")
        }

        getByName(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8

    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    testOptions {
        unitTests.isReturnDefaultValues = TestOptions.IS_RETURN_DEFAULT_VALUES
    }
}

dependencies {
    api(LibraryDependency.KOTLIN)
    api(LibraryDependency.COROUTINES_ANDROID)
    api(LibraryDependency.CORE_KTX)
    implementation(LibraryDependency.ROOM_CORE)
    kapt(LibraryDependency.ROOM_COMPILER)
    implementation(LibraryDependency.ROOM_KTX)

    addTestDependencies()
}