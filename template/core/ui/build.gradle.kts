plugins {
    alias(libs.plugins.template.android.feature)
    alias(libs.plugins.template.coroutines)
}

android {
    namespace = "io.bloco.core.ui"
}

dependencies {
    testImplementation(libs.junit)
}