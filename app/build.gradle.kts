import org.jetbrains.kotlin.config.KotlinCompilerVersion


plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("io.fabric")
    id ("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "ru.sberbank.sberinvestor"
        minSdkVersion(23)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"

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
        named("release").configure {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
           // signingConfig = signingConfigs["play"]
        }
    }

    bundle {
        language {
            enableSplit = true
        }
        density {
            enableSplit = true
        }
        abi {
            enableSplit = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    viewBinding.isEnabled = true

    kapt {
        correctErrorTypes = true

        javacOptions {
            option("SomeJavacOption", "OptionValue")
        }
        generateStubs = true
    }

    lintOptions {
        // By default lint does not check test sources, but setting this option means that lint will not even parse them
        isIgnoreTestSources = true
    }

    dependencies {
        // default dependencies
        implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
        implementation(kotlin("stdlib-jdk7", KotlinCompilerVersion.VERSION))
        // androidx support libraries
        implementation("com.google.android.material:material:1.2.0-alpha05")
        implementation("androidx.legacy:legacy-support-v13:1.0.0")
        implementation("androidx.recyclerview:recyclerview:1.1.0")
        implementation("androidx.cardview:cardview:1.0.0")
        implementation("androidx.appcompat:appcompat:1.1.0")
        implementation("androidx.core:core-ktx:1.2.0")
        implementation("androidx.constraintlayout:constraintlayout:1.1.3")
        // androidx lifecycle
        val lifecycleVersion = "2.2.0"
        implementation("androidx.lifecycle:lifecycle-extensions:$lifecycleVersion")
        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
        implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
        implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycleVersion")

        val navVersion = "2.3.0-alpha02"
        // navigation
        implementation( "androidx.navigation:navigation-fragment-ktx:$navVersion")
        implementation( "androidx.navigation:navigation-ui-ktx:$navVersion")
        //fragment
        val fragmentVersion= "1.2.2"
        implementation("androidx.fragment:fragment:$fragmentVersion")
        implementation("androidx.fragment:fragment-ktx:$fragmentVersion")
        implementation("androidx.fragment:fragment-testing:$fragmentVersion")
        //test base
        testImplementation("junit:junit:4.12")
        androidTestImplementation("androidx.test:runner:1.2.0")
        androidTestImplementation("com.android.support.test.espresso:espresso-core:3.0.2")
    }

}