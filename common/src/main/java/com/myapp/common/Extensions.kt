package com.priyoshop.common

import android.content.res.Resources
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

fun View.setMargins(
    marginLeft: Int,
    marginTop: Int,
    marginRight: Int,
    marginBottom: Int
) {
    val params: LinearLayout.LayoutParams =
        LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    params.setMargins(marginLeft.dp, marginTop.dp, marginRight.dp, marginBottom.dp)
    this.layoutParams = params
}

val Int.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()