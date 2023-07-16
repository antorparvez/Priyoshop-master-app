package com.priyoshop.common.extfun

import android.app.Activity
import android.content.Intent


object IntentKey {
    const val screenName = "screenName"
    const val districtSearch = "districtSearch"
    const val homeAddressSearch = "homeAddressSearch"
    const val policeStationSearch = "policeStationSearch"
    const val businessverticalSearch = "businessverticalSearch"
}

fun Activity.navigateCredentialNavHostActivity() {
    startActivity(
        Intent().addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            .setClassName(this, "com.priyoshop.zero.host.CredentialNavHostActivity")
    )
    finish()
}

fun Activity.navigateCommonNavHostActivity() {
    startActivity(
        Intent().addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            .setClassName(this, "com.priyoshop.zero.host.CommonNavHostActivity")
    )
    finish()
}
