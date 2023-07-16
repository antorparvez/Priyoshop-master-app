plugins {
    id("com.android.library")
    id("kotlin-android")
}
apply {
    from("$rootDir/android-config-dependencies.gradle")
}
dependencies {
    api(project(ModulesDep.assets))
    implementation(AppDep.appCompat)
    implementation(AppDep.activity)
    implementation(AppDep.recyclerview)
    implementation(AppDep.liveData)
    implementation(AppDep.viewModel)
    implementation(AppDep.rxJava3)
    implementation(AppDep.rxJava3Android)
    implementation(AppDep.material)
    implementation(AppDep.preference)
    implementation(AppDep.playStoreCore)
    implementation(AppDep.picasso)
    implementation(AppDep.circleImageview)
    implementation(AppDep.imageResizer)
    implementation(AppDep.okhHttp3Interceptor)
    implementation(AppDep.navigationFragment)
    implementation(AppDep.navigationUi)


}
