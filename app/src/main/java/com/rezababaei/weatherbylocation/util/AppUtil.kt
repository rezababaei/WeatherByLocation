package com.rezababaei.weatherbylocation.util

import android.content.Context
import android.graphics.drawable.Drawable
import android.net.ConnectivityManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

object AppUtil {
    fun  setWeatherIcon(imageView: ImageView, iconCode: String) {
        val context=imageView.context
        val id = context.resources.getIdentifier("ic_$iconCode", "drawable", context.packageName)
        Glide.with(imageView.context).load(id).into(imageView)
    }

}