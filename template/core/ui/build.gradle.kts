import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    alias(libs.plugins.template.android.feature)
    alias(libs.plugins.template.coroutines)
    id(libs.plugins.hilt.android.get().pluginId)
    kotlin("kapt")
}

android {
    namespace = "io.bloco.core.ui"

    buildFeatures { compose = true }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }

    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + listOf(
            "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api",
        )
    }
}

dependencies {
    // projects
    implementation(projects.core.commons)
    implementation(projects.core.domain)

    // libs
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    // test
    testImplementation(libs.junit)
}