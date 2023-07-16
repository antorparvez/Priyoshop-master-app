package com.priyoshop.common.extfun

import android.widget.ImageView
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

fun Picasso.loadImage(url:String, imageView: ImageView) {
    this.load(url).into(imageView)
}

fun ImageView.loadImage(url : String)
{
    Picasso.get().load(url)
        .into(this)
}

fun CircleImageView.loadImage(url : String)
{
    Picasso.get().load(url)
        .into(this)
}