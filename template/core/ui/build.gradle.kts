plugins {
    alias(libs.plugins.template.kotlin.feature)
    alias(libs.plugins.template.coroutines)
}

//android {
//    namespace = "io.bloco.core.ui"
//}

dependencies {
    testImplementation(libs.junit)
}