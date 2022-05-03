package com.rezababaei.weatherbylocation.network

import com.rezababaei.weatherbylocation.network.datamodel.WeatherResponse
import retrofit2.Call


interface ApiRepository {
    suspend fun getWeather(lat:String?, lon:String?, callback: RequestCompleteListener<WeatherResponse>)

}