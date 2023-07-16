package com.priyoshop.common.extfun

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.SystemClock
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible
import java.util.regex.Pattern

fun EditText.getTextFromEt():String = this.text.toString().trim()
fun AutoCompleteTextView.getTextFromAt():String = this.text.toString().trim()
fun TextView.getTextFromTv():String = this.text.toString().trim()

fun EditText.isEmptyInput(errorMessage:String):Boolean{
    val input = this.text.toString().trim()
    if (input.isEmpty()) this.error = errorMessage
    return input.isEmpty()
}

fun TextView.isEmpty(text: String, errorText: String, errorTV: TextView): Boolean {
    errorTV.isVisible = text.isBlank()
    errorTV.text = errorText
    return text.isBlank()
}

fun Context.showKeyboard(){
    val imm = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0)
}

fun Context.hideKeyboard(){
    val imm = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
}

fun View.hideKeyboard() {
    val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
}

fun Activity.starPhoneCallDial(phoneNumber:String?){
    phoneNumber?.let {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$it")
        startActivity(intent)
    }
}

fun View.clickWithDebounce(debounceTime: Long =1200L, action: () -> Unit) {
    this.setOnClickListener(object : View.OnClickListener {
        private var lastClickTime: Long = 0
        override fun onClick(v: View) {
            if (SystemClock.elapsedRealtime() - lastClickTime < debounceTime) return
            else action()
            lastClickTime = SystemClock.elapsedRealtime()
        }
    })
}

fun EditText.isNotMandatoryEmailValid():String{
    val emailRegex = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )
    val emailText = this.getTextFromTv()
    if (emailText.isNotEmpty() && !Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
        this.error = "আপনার ইমেইল সঠিক নয়"
    }
    return emailText
}

fun EditText.isEmailValid(email: CharSequence): Boolean {
    return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
}
//
//fun Group.addOnClickListener(listener: (view: View) -> Unit) {
//    referencedIds.forEach { id ->
//        rootView.findViewById<View>(id).setOnClickListener(listener)
//    }
//}



