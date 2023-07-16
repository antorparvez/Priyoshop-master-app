object AppDep {

    const val appCompat = "androidx.appcompat:appcompat:${DepVersion.appcompatVersion}"
    const val coreKtx = "androidx.core:core-ktx:${DepVersion.coreKtxVersion}"
    const val playStoreCore = "com.google.android.play:app-update:${DepVersion.playCoreVersion}"
    const val playStoreKtx =
        "com.google.android.play:app-update-ktx:${DepVersion.playCoreKtxVersion}"

    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${DepVersion.constraintLayoutVersion}"
    const val material = "com.google.android.material:material:${DepVersion.materialVersion}"
    const val fragment = "androidx.fragment:fragment-ktx:${DepVersion.fragmentVersion}"
    const val activity = "androidx.activity:activity-ktx:${DepVersion.activityVersion}"
    const val cardView = "androidx.cardview:cardview:${DepVersion.cardViewVersion}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${DepVersion.recyclerViewVersion}"
    const val viewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${DepVersion.lifecycleVersion}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${DepVersion.lifecycleVersion}"
    const val lifecycle = "androidx.lifecycle:lifecycle-common-java8:${DepVersion.lifecycleVersion}"
    const val lifecycleService =
        "androidx.lifecycle:lifecycle-service:${DepVersion.lifecycleVersion}"
    const val preference = "androidx.preference:preference:${DepVersion.preferenceVersion}"

    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${DepVersion.navigationVersion}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${DepVersion.navigationVersion}"
    const val navigationSafeArgs =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${DepVersion.navigationSafeArgsVersion}"

    const val hiltAndroid = "com.google.dagger:hilt-android:${DepVersion.hiltVersion}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${DepVersion.hiltVersion}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${DepVersion.retrofitVersion}"
    const val rxJava3adapter =
        "com.squareup.retrofit2:adapter-rxjava3:${DepVersion.retrofitVersion}"
    const val retrofitGsonConverter =
        "com.squareup.retrofit2:converter-gson:${DepVersion.retrofitVersion}"
    const val okhHttp3 = "com.squareup.okhttp3:okhttp:${DepVersion.okhttp3Version}"
    const val okhHttp3Interceptor =
        "com.squareup.okhttp3:logging-interceptor:${DepVersion.okhttp3Version}"
    const val gson = "com.google.code.gson:gson:${DepVersion.gsonVersion}"

    const val rxJava3 = "io.reactivex.rxjava3:rxjava:${DepVersion.rxJava3Version}"
    const val rxJava3Android = "io.reactivex.rxjava3:rxandroid:${DepVersion.rxAndroid3Version}"

    const val picasso = "com.squareup.picasso:picasso:${DepVersion.picassoVersion}"
    const val coil = "io.coil-kt:coil:${DepVersion.coilVersion}"
    const val sdp = "com.intuit.sdp:sdp-android:${DepVersion.sdpVersion}"
    const val ssp = "com.intuit.ssp:ssp-android:${DepVersion.sdpVersion}"
    const val circleImageview = "de.hdodenhof:circleimageview:${DepVersion.circleImageViewVersion}"
    const val kotlinCoroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${DepVersion.coroutinesVersion}"
    const val leakcanary =
        "com.squareup.leakcanary:leakcanary-android:${DepVersion.leakcanaryVersion}"
    const val dotIndicator = "com.tbuonomo:dotsindicator:${DepVersion.viewPagerDotIndicatorVersion}"
    const val timber = "com.jakewharton.timber:timber:${DepVersion.timberVersion}"

    const val facebookSdk =
        "com.facebook.android:facebook-android-sdk:${DepVersion.facebookVersion}"
    const val facebookMarketing =
        "com.facebook.android:facebook-marketing:${DepVersion.facebookMarketingVersion}"

    const val mapSdk = "com.google.android.gms:play-services-maps:${DepVersion.mapVersion}"
    const val mapLocation =
        "com.google.android.gms:play-services-location:${DepVersion.mapLocationVersion}"
    const val mapPlaces = "com.google.android.libraries.places:places:${DepVersion.mapPlaceVersion}"

    const val firebaseBom = "com.google.firebase:firebase-bom:${DepVersion.firebaseBomVersion}"
    const val firebaseCore = "com.google.firebase:firebase-core"
    const val firebaseMessaging = "com.google.firebase:firebase-messaging-ktx"
    const val firebaseAnalytics = "com.google.firebase:firebase-analytics-ktx"
    const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics-ktx"

    const val room = "androidx.room:room-ktx:${DepVersion.roomVersion}"
    const val roomRuntime = "androidx.room:room-runtime:${DepVersion.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${DepVersion.roomVersion}"

    const val junit = "junit:junit:${DepVersion.junitVersion}"
    const val extJunit = "androidx.test.ext:junit:${DepVersion.junitExtVersion}"
    const val espresso = "androidx.test.espresso:espresso-core:${DepVersion.espressoVersion}"
    const val swipeToRefreshLayout =
        "androidx.swiperefreshlayout:swiperefreshlayout:${DepVersion.swipeLayoutVersion}"

    //GLIDE
    const val glide = "com.github.bumptech.glide:glide:${DepVersion.glideVersion}"
    const val glideCompiler =
        "com.github.bumptech.glide:compiler:${DepVersion.glideCompilerVersion}"
    const val imagePicker = "com.github.Drjacky:ImagePicker:${DepVersion.imagePickerVersion}"
    const val imageResizer = "com.github.hkk595:Resizer:${DepVersion.imageResizerVersion}"
    const val playCore = "com.google.android.play:core-ktx:${DepVersion.playCoreVersion}"

    //lottie
    const val lottie = "com.airbnb.android:lottie:${DepVersion.lottieVersion}"

    // Coroutine Lifecycle Scopes
    const val lifecycleLivedata =
        "androidx.lifecycle:lifecycle-livedata-ktx:${DepVersion.livedataVersion}"
    const val lifecycleViewmodel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${DepVersion.viewmodelVersion}"
}