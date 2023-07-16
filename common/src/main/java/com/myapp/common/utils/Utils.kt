package com.priyoshop.common.utils

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.OpenableColumns
import android.text.InputFilter
import android.text.SpannableString
import android.text.Spanned
import android.text.TextUtils
import android.util.Log
import me.echodev.resizer.Resizer
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.text.DecimalFormat
import java.util.regex.Matcher
import java.util.regex.Pattern


object Utils {
    val SpecialCharPattern = "[^.্ূীুিেোাৃ্ ]".toRegex()
    fun formatPhoneNumber(phoneNumber: String): String {
        return when {
            phoneNumber.startsWith("+880") -> phoneNumber
            phoneNumber.substring(0, 1) == "0" -> "+88$phoneNumber"
            else -> "+880$phoneNumber"
        }
    }

    fun isPhoneNumberValid(number: String): Boolean {
        val pattern: Pattern =
            Pattern.compile("((0|01|\\+88|\\+88\\s*\\(0\\)|\\+88\\s*0)\\s*)?1(\\s*[0-9]){9}")
        val matcher: Matcher = pattern.matcher(number)
        return matcher.matches()
    }

    fun isNidValid(nid: String): Boolean {
        if (!intArrayOf(10, 13, 17).contains(nid.length)) return false
        if (!isNumeric(nid)) return false
        return true
    }

    private fun isNumeric(toCheck: String): Boolean {
        return toCheck.all { char -> char.isDigit() }
    }

    fun getFile(context: Context, thisURI: Uri?): File {
        val destinationFilename = File(context.filesDir.path + File.separatorChar + thisURI?.let {
            queryName(context, it)
        })
        try {
            if (thisURI != null) {
                context.contentResolver.openInputStream(thisURI).use { ins ->
                    if (ins != null) {
                        createFileFromStream(ins, destinationFilename)
                    }
                }
            }
        } catch (ex: Exception) {
            Log.e("Save File", ex.message!!)
            ex.printStackTrace()
        }
        return destinationFilename
    }

    private fun queryName(context: Context, uri: Uri): String {
        val returnCursor: Cursor = context.contentResolver.query(uri, null, null, null, null)!!
        val nameIndex: Int = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
        returnCursor.moveToFirst()
        val name: String = returnCursor.getString(nameIndex)
        returnCursor.close()
        return name
    }

    private fun createFileFromStream(ins: InputStream, destination: File?) {
        try {
            FileOutputStream(destination).use { os ->
                val buffer = ByteArray(4096)
                var length: Int
                while (ins.read(buffer).also { length = it } > 0) {
                    os.write(buffer, 0, length)
                }
                os.flush()
            }
        } catch (ex: java.lang.Exception) {
            Log.e("Save File", ex.message!!)
            ex.printStackTrace()
        }
    }

    class FileRequestPart(
        val filename: String,
        val imageRequestFormData: MultipartBody.Part
    )

    fun createMultipartBodyForImage(
        context: Context,
        thisURI: Uri?,
        name: String
    ): FileRequestPart {
        val file = getFile(context, thisURI)

        val photoFile = Resizer(context)
            .setQuality(30)
            .setOutputFormat("JPEG")
            .setSourceImage(file)
            .resizedFile
        val requestFile: RequestBody =
            photoFile.asRequestBody("multipart/form-data".toMediaTypeOrNull())

        return FileRequestPart(
            photoFile.name,
            MultipartBody.Part.createFormData(name, photoFile.name, requestFile)
        )
    }

    fun getEnglishNumberInBangla(string: String): String {
        val banglaNumber = arrayOf('0', '১', '২', '৩', '৪', '৫', '৬', '৭', '৮', '৯')
        val engNumber = arrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
        val values = StringBuilder()
        val character = string.toCharArray()
        for (value in character) {
            var c = ' '
            for (j in engNumber.indices) {
                if (value == engNumber[j]) {
                    c = banglaNumber[j]
                    break
                } else {
                    c = value
                }
            }
            values.append(c)
        }
        return values.toString()
    }

     val usernameAllowedCharsRegex =
        Regex("[A-Za-z. ◌ঁ-ঃঅ-ঋএঐওঔক-নপ-রলশ-হ\\u09BC-\\u09C3\\u09C7-\\u09C8\\u09CB-\\u09CE\\u09D7\\u09DC\\u09DD\\u09DF\\u09E0\\u09FD]")
     val usernameFilter =
        InputFilter { source, start, end, dest, dstart, dend ->
            val builder = StringBuilder(end - start)
            for (i in start until end) {
                val c: Char = source[i]
                if (usernameAllowedCharsRegex.containsMatchIn(c.toString()))
                    builder.append(c)
            }

            val keepOriginal = builder.length == end - start
            if (keepOriginal) null else {
                if (source is Spanned) {
                    val sp = SpannableString(builder)
                    TextUtils.copySpansFrom(source, start, builder.length, null, sp, 0)
                    sp
                } else {
                    builder
                }
            }
        }

    fun decimalFormat(value: Double): String? {
        val decimalFormat = DecimalFormat("#.##")
        decimalFormat.minimumFractionDigits = 2
        return decimalFormat.format(value)
    }
}