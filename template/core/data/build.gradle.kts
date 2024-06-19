plugins {
    id("template.kotlin.feature")
    id("template.coroutines")
    id(libs.plugins.kotlin.serialization.get().pluginId)
}

dependencies {
    implementation(projects.core.commons)
    implementation(libs.bundles.network)
    implementation(libs.datastore)

    testImplementation(projects.core.dataTest)
}
