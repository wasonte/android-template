plugins {
    alias(libs.plugins.template.kotlin.feature)
    alias(libs.plugins.template.coroutines)
    alias(libs.plugins.kotlin.serialization)
}

dependencies {
    implementation(projects.core.commons)
    implementation(projects.core.data)

    implementation(libs.ktor.engine.mock)
}
