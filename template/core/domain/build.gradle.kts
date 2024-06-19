plugins {
    id("template.kotlin.feature")
    id("template.coroutines")
}

dependencies {
    implementation(projects.core.commons)
    implementation(projects.core.data)

    implementation(libs.bundles.javax)
}
