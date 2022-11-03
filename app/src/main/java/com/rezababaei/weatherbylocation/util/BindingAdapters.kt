package com.rezababaei.weatherbylocation.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.rezababaei.weatherbylocation.R

/**
@Author: Reza Nazari
@Date: 9/23/21
@Email: Nazari.reza66@gmail.com
 **/

@BindingAdapter("isVisible")
fun View.isVisible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE
    else View.GONE
}

@BindingAdapter("isVisInvis")
fun View.isVisInvis(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE
    else View.INVISIBLE
}

@BindingAdapter("imageUrl")
fun ImageView.loadImage(url: String) {
    Glide.with(context).load(url).placeholder(R.drawable.ic_image).into(this)
}



