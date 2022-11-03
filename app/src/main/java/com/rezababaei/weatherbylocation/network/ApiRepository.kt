package com.rezababaei.weatherbylocation.network

import com.rezababaei.weatherbylocation.BuildConfig
import com.rezababaei.weatherbylocation.network.datamodel.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiRepository {
    suspend fun getWeather(lat:String?, lon:String?, callback: RequestCompleteListener<WeatherResponse>)



}