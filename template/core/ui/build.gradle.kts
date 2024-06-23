plugins {
    alias(libs.plugins.template.android.feature)
    alias(libs.plugins.template.coroutines)
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
    implementation(libs.bundles.compose)

    testImplementation(libs.junit)
}