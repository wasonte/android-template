plugins {
    id("template.kotlin.feature")
    id("template.coroutines")
    id(libs.plugins.kotlin.serialization.get().pluginId)
}

dependencies {
    implementation(projects.core.commons)
    implementation(projects.core.data)

    implementation(libs.ktor.engine.mock)
}
