package com.rezababaei.weatherbylocation.util

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide

object AppUtil {
    fun  setWeatherIcon(imageView: ImageView, iconCode: String) {
//        var imageId= if (weatherCode / 100 == 2) {
//            R.drawable.ic_storm_weather
//        } else if (weatherCode / 100 == 3) {
//            R.drawable.ic_rainy_weather
//        } else if (weatherCode / 100 == 5) {
//            R.drawable.ic_rainy_weather
//        } else if (weatherCode / 100 == 6) {
//            R.drawable.ic_snow_weather
//        } else if (weatherCode / 100 == 7) {
//            R.drawable.ic_unknown
//        } else if (weatherCode == 800) {
//            R.drawable.ic_clear_day
//        } else if (weatherCode == 801) {
//            R.drawable.ic_few_clouds
//        } else if (weatherCode == 803) {
//            R.drawable.ic_broken_clouds
//        } else if (weatherCode / 100 == 8) {
//            R.drawable.ic_cloudy_weather
//        }else{
//            R.drawable.ic_unknown
//        }

//        Glide.with(imageView.context).load(imageId).into(imageView)
//
//        val uri = "@drawable/team_logo_"+iconCode;
//
//        ivImage.setImageDrawable(logoDrawable)
        val context=imageView.context
        val id = context.resources.getIdentifier("ic_$iconCode", "drawable", context.packageName)

        Glide.with(imageView.context).load(id).into(imageView)

    }
}