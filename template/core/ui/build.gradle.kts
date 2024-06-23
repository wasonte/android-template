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
}

dependencies {
    implementation(libs.bundles.compose)

    testImplementation(libs.junit)
}