package com.rezababaei.weatherbylocation.network

import com.rezababaei.weatherbylocation.BuildConfig
import com.rezababaei.weatherbylocation.network.datamodel.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    // this will be handled by our custom CallAdapter
    @GET("onecall?")
    fun getWeather(
        @Query("lat") lat: String?,
        @Query("lon") lon: String?,
        @Query("APPID") app_id: String? = BuildConfig.APP_ID,
        @Query("units") units: String? = "metric",
    ): Call<WeatherResponse>



}