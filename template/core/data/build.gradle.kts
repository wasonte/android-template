plugins {
    id("template.kotlin.feature")
    id("template.coroutines")
    alias(libs.plugins.kotlin.serialization)
}

dependencies {
    implementation(projects.core.commons)
    implementation(libs.bundles.network)
    implementation(libs.datastore)

    testImplementation(projects.core.dataTest)
}
