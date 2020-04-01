plugins {
    id(GradlePluginId.ANDROID_DYNAMIC_FEATURE)
    kotlin(GradlePluginId.KOTLIN_ANDROID)
    kotlin(GradlePluginId.KOTLIN_ANDROID_EXTENSIONS)
    kotlin(GradlePluginId.KOTLIN_KAPT)
    id(GradlePluginId.SAFE_ARGS)
    id(GradlePluginId.KOIN)
    id(GradlePluginId.JUNIT5)
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)

        versionCode = AndroidConfig.VERSION_CODE
        versionName = AndroidConfig.VERSION_NAME
        testInstrumentationRunner = AndroidConfig.TEST_INSTRUMENTATION_RUNNER

        testInstrumentationRunnerArgument("runnerBuilder", "de.mannodermaus.junit5.AndroidJUnit5Builder")
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

    // 4) JUnit 5 will bundle in files with identical paths; exclude them
    packagingOptions {
        exclude("META-INF/LICENSE*")
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


    testImplementation("io.mockk:mockk:1.9.3")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.5")


    /**
     *  start for junit5
     */
    // (Required) Writing and executing Unit Tests on the JUnit Platform
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")

    // (Optional) If you need "Parameterized Tests"
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.6.0")

    // (Optional) If you also have JUnit 4-based tests
    testImplementation("junit:junit:4.13")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:5.6.0")

    // 5) Jupiter API & Test Runner, if you don't have it already
    androidTestImplementation("androidx.test:runner:1.2.0")
    androidTestImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")

    // 6) The instrumentation test companion libraries
    androidTestImplementation("de.mannodermaus.junit5:android-test-core:1.2.0")
    androidTestRuntimeOnly("de.mannodermaus.junit5:android-test-runner:1.2.0")

    /**
     *  end for junit5
     */
}
