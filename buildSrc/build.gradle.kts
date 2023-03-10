plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") {
        name = "PaperMC Repository"
    }
}

dependencies {
    implementation("gradle.plugin.com.github.johnrengelman:shadow:8.0.0")
    implementation("gradle.plugin.org.cadixdev.gradle:licenser:0.6.1")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.15.0")
    implementation("com.github.spotbugs.snom:spotbugs-gradle-plugin:5.0.13")
    implementation("net.kyori:indra-common:3.0.1")
    implementation("io.github.patrick.remapper:io.github.patrick.remapper.gradle.plugin:1.4.0")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

kotlin {
    jvmToolchain(17)
}
