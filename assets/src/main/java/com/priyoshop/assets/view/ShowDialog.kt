package com.priyoshop.common.utils

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.provider.Settings
import android.util.Log
import android.view.*
import android.webkit.WebView
import android.widget.*
import com.priyoshop.assets.R
import com.priyoshop.assets.view.CustomET
import com.priyoshop.assets.view.CustomTV

fun Context.showDialog(
    title: String,
    description: String,
    titleOfPositiveButton: String? = null,
    titleOfNegativeButton: String? = null,
    positiveButtonFunction: (() -> Unit)? = null,
    negativeButtonFunction: (() -> Unit)? = null
) {
    val dialog = Dialog(this, R.style.AlertDialogCustom)
    dialog.window?.requestFeature(Window.FEATURE_NO_TITLE) // if you have blue line on top of your dialog, you need use this code
    dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    dialog.setCancelable(false)
    dialog.setContentView(R.layout.dialog_alert)
    val dialogTitle = dialog.findViewById(R.id.title) as TextView
    val dialogDescription = dialog.findViewById(R.id.description) as TextView
    val dialogPositiveButton = dialog.findViewById(R.id.positiveButton) as TextView
    val dialogNegativeButton = dialog.findViewById(R.id.negativeButton) as TextView
    dialogTitle.text = title
    dialogDescription.text = description
    titleOfPositiveButton?.let { dialogPositiveButton.text = it } ?: dialogPositiveButton.makeGone()
    titleOfNegativeButton?.let { dialogNegativeButton.text = it } ?: dialogNegativeButton.makeGone()
    dialogPositiveButton.setOnClickListener {
        positiveButtonFunction?.invoke()
        dialog.dismiss()
    }
    dialogNegativeButton.setOnClickListener {
        negativeButtonFunction?.invoke()
        dialog.dismiss()
    }
    dialog.show()
}

private fun View.makeGone() {
    this.visibility = View.GONE
}


fun Context.showNoInternetDialog() {
    val dialog = Dialog(this, R.style.AlertDialogCustom)
    dialog.window?.requestFeature(Window.FEATURE_NO_TITLE) // if you have blue line on top of your dialog, you need use this code
    dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    dialog.setCancelable(false)
    dialog.setContentView(R.layout.dialog_no_internet)
    val dialogPositiveButton = dialog.findViewById(R.id.positiveButton) as Button
    val dialogNegativeButton = dialog.findViewById(R.id.negativeButton) as ImageView
    dialogPositiveButton.setOnClickListener {
        val intent = Intent(Settings.ACTION_NETWORK_OPERATOR_SETTINGS)
        startActivity(intent)

        dialog.dismiss()
    }
    dialogNegativeButton.setOnClickListener {
        dialog.dismiss()
    }
    dialog.show()
}

fun Context.showAddQtyDialog(
    okButtonFunction: ((data: String) -> Unit)? = null,
) {
    val dialog = Dialog(this, R.style.AlertDialogCustom)
    dialog.window?.requestFeature(Window.FEATURE_NO_TITLE) // if you have blue line on top of your dialog, you need use this code
    dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    dialog.setCancelable(true)
    dialog.setContentView(R.layout.dialog_add_qty)
    val dialogButton = dialog.findViewById(R.id.buttonTv) as CustomTV
    val dialogEnterQty = dialog.findViewById(R.id.enterQtyEt) as CustomET
    val dialogRemoveButton = dialog.findViewById(R.id.removeIv) as ImageView
    dialogEnterQty.isCursorVisible = true
    var itemqty = "";
    dialogButton.setOnClickListener {
        Log.d("TAG", "onClickDropDownTradfnsferTo")
        itemqty = dialogEnterQty.text.toString()
        if (itemqty.isNotEmpty()) {
            okButtonFunction?.invoke(itemqty)
            dialog.dismiss()
        } else {
            dialog.dismiss()
        }
    }

    dialogRemoveButton.setOnClickListener {

        dialog.dismiss()
    }

    dialog.show()
}

