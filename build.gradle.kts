import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven (url = "https://maven.fabric.io/public" )
        gradlePluginPortal()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:3.6.1")
        classpath ("io.fabric.tools:gradle:1.31.0")
        classpath ("com.google.gms:google-services:4.3.3")
        classpath ("com.google.firebase:firebase-plugins:1.1.5")
        classpath(kotlin("gradle-plugin", version = "1.3.70"))
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.0-alpha03")
        classpath ("org.koin:koin-gradle-plugin:2.1.3")
        classpath ("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.6.0")
       // classpath ("org.jlleitschuh.gradle:ktlint-gradle:9.1.1")
    }
}

plugins {
    id(GradlePluginId.KTLINT_GRADLE) version "9.1.1"
    id(GradlePluginId.DETEKT) version "1.4.0"
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven (url = "https://maven.fabric.io/public" )
        gradlePluginPortal()
    }

    apply(plugin = GradlePluginId.DETEKT)

    detekt {
        config = files("${project.rootDir}/detekt.yml")
        parallel = true
    }
}

// JVM target applied to all Kotlin tasks across all sub-projects
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
}


task("staticCheck") {
    description =
        """Mimics all static checks that run on CI.
        Note that this task is intended to run locally (not on CI), because on CI we prefer to have parallel execution
        and separate reports for each check (multiple statuses eg. on github PR page).
        """.trimMargin()

    group = "verification"
    afterEvaluate {
        // Filter modules with "lintDebug" task (non-Android modules do not have lintDebug task)
        val lintTasks = subprojects.mapNotNull { "${it.name}:lintDebug" }

        // Get modules with "testDebugUnitTest" task (app module does not have it)
        val testTasks = subprojects.mapNotNull { "${it.name}:testDebugUnitTest" }
            .filter { it != "app:testDebugUnitTest" }

        // All task dependencies
        val taskDependencies =
           // добавить "ktlintCheck" когда дойдут руки
            mutableListOf("app:assembleAndroidTest", "detekt").also {
                it.addAll(lintTasks)
                it.addAll(testTasks)
            }

        // By defining Gradle dependency all dependent tasks will run before this "empty" task
        dependsOn(taskDependencies)
    }
}