plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.template.coroutines)
    id(libs.plugins.hilt.android.get().pluginId)
    kotlin("kapt")
}

android {
    compileSdk = libs.versions.sdk.compile.get().toInt()

    defaultConfig {
        applicationId = "io.bloco.template"

        minSdk = libs.versions.sdk.min.get().toInt()
        targetSdk = libs.versions.sdk.target.get().toInt()

        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "io.bloco.template.TestRunner"
        vectorDrawables { useSupportLibrary = true }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    hilt { enableAggregatingTask = true }

    buildFeatures { compose = true }

    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + listOf(
            "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api",
        )
    }

    kotlin {
        jvmToolchain(11)
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
            excludes.add("/META-INF/LICENSE*")
        }
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
    namespace = "io.bloco.template"
}

dependencies {
    // Project Dependencies
    implementation(projects.core.ui)
    implementation(projects.core.domain)
    implementation(projects.core.commons)

    // Dependencies
    // Compose
    implementation(libs.bundles.compose)

    // Hilt
    implementation(libs.hilt.navigation.compose)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    // Ktor Engine
    implementation(libs.ktor.core)
    implementation(libs.ktor.engine.android)

    // SplashScreen
    implementation(libs.splashscreen)

    // Datastore
    implementation(libs.datastore.android)

    // Debug Dependencies
    debugImplementation(libs.bundles.compose.debug)

    // Android Test Dependencies
    androidTestImplementation(libs.hilt.test)
    kaptAndroidTest(libs.hilt.test.compiler)

    androidTestImplementation(libs.test.core)
    androidTestImplementation(libs.bundles.compose.test)
    androidTestImplementation(libs.ktor.engine.mock)

    // Test Dependencies
    testImplementation(libs.bundles.test.core)
    testImplementation(libs.mockk.agent)
    testImplementation(libs.mockk.android)
}
