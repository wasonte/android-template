plugins {
    id("template.kotlin.feature")
    id("template.coroutines")
    alias(libs.plugins.kotlin.serialization)
}

dependencies {
    implementation(projects.core.commons)
    implementation(projects.core.data)

    implementation(libs.ktor.engine.mock)
}
