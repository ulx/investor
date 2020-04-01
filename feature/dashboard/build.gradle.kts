plugins {
    id(GradlePluginId.ANDROID_DYNAMIC_FEATURE)
    kotlin(GradlePluginId.KOTLIN_ANDROID)
    kotlin(GradlePluginId.KOTLIN_ANDROID_EXTENSIONS)
    kotlin(GradlePluginId.KOTLIN_KAPT)
    id(GradlePluginId.SAFE_ARGS)
    id(GradlePluginId.KOIN)
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)

        versionCode = AndroidConfig.VERSION_CODE
        versionName = AndroidConfig.VERSION_NAME
        testInstrumentationRunner = AndroidConfig.TEST_INSTRUMENTATION_RUNNER
    }

    viewBinding.isEnabled = true

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

    // This "test" source set is a fix for SafeArgs classes not being available when running Unit tests from cmd
    // See: https://issuetracker.google.com/issues/139242292
    sourceSets {
        getByName("test").java.srcDir("${project.rootDir}/app/build/generated/source/navigation-args/debug")
    }

    // Removes the need to mock need to mock classes that may be irrelevant from test perspective
    testOptions {
        unitTests.isReturnDefaultValues = TestOptions.IS_RETURN_DEFAULT_VALUES
        unitTests.isIncludeAndroidResources = true
    }
}

dependencies {
    implementation(project(ModuleDependency.APP))

    addTestDependencies()

    val robolectricVersion = "4.3.1"
    val coreVersion = "1.3.0-alpha04"
    val extJUnitVersion = "1.1.2-alpha04"
    val espressoVersion = "3.3.0-alpha04"
    val runnerVersion = "1.3.0-alpha04"
    testImplementation("org.robolectric:robolectric:$robolectricVersion")
    testImplementation("androidx.test:core:$coreVersion")
    testImplementation("androidx.test:core-ktx:$coreVersion")
    testImplementation("androidx.test.ext:junit:$extJUnitVersion")
    testImplementation("androidx.test.espresso:espresso-core:$espressoVersion")

    androidTestImplementation("androidx.test:core:$coreVersion")
    androidTestImplementation("androidx.test:core-ktx:$coreVersion")
    androidTestImplementation("androidx.test.ext:junit:$extJUnitVersion")
    androidTestImplementation("androidx.test:runner:$runnerVersion")
    androidTestImplementation("androidx.test.espresso:espresso-core:$espressoVersion")
    androidTestImplementation("org.robolectric:annotations:$robolectricVersion")

    kapt("com.google.auto.service:auto-service:1.0-rc5")

    testImplementation("io.mockk:mockk:1.9.3")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.5")
}
