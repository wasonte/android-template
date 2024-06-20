plugins {
    alias(libs.plugins.template.android.library)
    alias(libs.plugins.template.coroutines)
}

android {
    namespace = "io.bloco.core.ui"
}

dependencies {
    testImplementation(libs.junit)
}