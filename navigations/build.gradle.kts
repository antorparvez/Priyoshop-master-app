plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

apply {
    from("$rootDir/android-config-dependencies.gradle")
}

dependencies {
    implementation(AppDep.navigationUi)
    implementation(AppDep.navigationFragment)
    /*implementation(project(ModulesDep.entity))
    implementation(project(ModulesDep.assets))*/
}
