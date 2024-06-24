plugins {
    alias(libs.plugins.template.kotlin.feature)
    alias(libs.plugins.template.coroutines)
}

dependencies {
    implementation(projects.core.commons)

    implementation(libs.bundles.javax)
}
