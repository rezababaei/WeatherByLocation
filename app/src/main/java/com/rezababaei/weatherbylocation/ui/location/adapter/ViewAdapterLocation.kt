package com.rezababaei.weatherbylocation.ui.location.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rezababaei.weatherbylocation.R
import com.rezababaei.weatherbylocation.network.datamodel.Daily
import com.rezababaei.weatherbylocation.util.AppUtil
import com.rezababaei.weatherbylocation.util.isToday
import com.rezababaei.weatherbylocation.util.loadImage
import com.rezababaei.weatherbylocation.util.unixTimestampToDayString
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class ViewAdapterLocation(private val dailyWeather: List<Daily>) :
    RecyclerView.Adapter<ViewAdapterLocation.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val dayTextView: TextView = itemView.findViewById(R.id.tv_day)
        private val weatherImage: ImageView = itemView.findViewById(R.id.image_weather)
        private val tempTextView: TextView = itemView.findViewById(R.id.tv_temperature)
        private val minWeatherTextView: TextView = itemView.findViewById(R.id.tv_min_weather)
        private val maxWeatherTextView: TextView = itemView.findViewById(R.id.tv_max_weather)


        fun bind(index: Daily) {


            // Here, we are using Glide library to
            // load the image into ImageView
            val weatherConditionIconUrl =
                "http://openweathermap.org/img/w/${index.weather?.get(0)?.icon}.png"
//            binding.ivWeather.loadImage(weatherConditionIconUrl)
//            Glide.with(itemView.context)
//                .load(weatherConditionIconUrl).dontAnimate()
//                .into(itemView.findViewById(R.id.image_weather))

            if (index.dt?.isToday() == true) {
                dayTextView.text = "Today"
            } else {
                dayTextView.text = index.dt?.unixTimestampToDayString()
            }
            AppUtil.setWeatherIcon(weatherImage, index.weather?.get(0)?.icon ?: "ic_unknown")
//            weatherImage.loadImage(weatherConditionIconUrl)
            var celsius = "\u00B0"
            tempTextView.text = String.format("%s%s", index.temp?.day?.toInt(), celsius)
            minWeatherTextView.text =  String.format("%s%s", index.temp?.min?.toInt(), celsius)
            maxWeatherTextView.text =  String.format("%s%s", index.temp?.max?.toInt(), celsius)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflating list data from list_item to view
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.weather_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dailyWeather[position])
    }

    override fun getItemCount() = dailyWeather.size

}