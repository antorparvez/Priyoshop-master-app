package com.priyoshop.assets.view

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.priyoshop.assets.R


class CustomImageHolder(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
    LinearLayout(context, attrs, defStyleAttr) {
    private var mImg: ImageView? = null
    private var mCameraBtn: ImageView? = null
    private var mDeleteBtn: ImageButton? = null
    private var mImgLabelTv: TextView? = null
    private lateinit var mContext: Context

    private var mUri: Uri? = null

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    init {
        init(context)
    }

    private fun init(context: Context) {
        if (isInEditMode) return
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val customView: View = inflater.inflate(R.layout.custom_image_holder, this) ?: return

        mContext = context
        mImg = customView.findViewById(R.id.img) as ImageView
        mCameraBtn = customView.findViewById(R.id.cameraBtn) as ImageView
        mDeleteBtn = customView.findViewById(R.id.deleteBtn) as ImageButton
        mImgLabelTv = customView.findViewById(R.id.imgLabelTv) as TextView
    }

    val img: ImageView?
        get() = mImg
    val cameraBtn: ImageView?
        get() = mCameraBtn
    val deleteBtn: ImageButton?
        get() = mDeleteBtn
    val imgLabelTv: TextView?
        get() = mImgLabelTv
    var uri: Uri?
        get() = mUri
        set(value) {
            mUri = value
        }
}