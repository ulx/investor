
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
        classpath ("com.github.ben-manes:gradle-versions-plugin:0.28.0")
        classpath ("org.jlleitschuh.gradle:ktlint-gradle:9.1.1")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven (url = "https://maven.fabric.io/public" )
    }
}
