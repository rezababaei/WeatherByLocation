package com.rezababaei.weatherbylocation.network.datamodel


import com.squareup.moshi.Json

data class Current(
    @Json(name = "clouds")
    val clouds: Int?,
    @Json(name = "dew_point")
    val dewPoint: Double?,
    @Json(name = "dt")
    val dt: Int?,
    @Json(name = "feels_like")
    val feelsLike: Double?,
    @Json(name = "humidity")
    val humidity: Int?,
    @Json(name = "pressure")
    val pressure: Int?,
    @Json(name = "sunrise")
    val sunrise: Int?,
    @Json(name = "sunset")
    val sunset: Int?,
    @Json(name = "temp")
    val temp: Double?,
    @Json(name = "uvi")
    val uvi: Double?,
    @Json(name = "visibility")
    val visibility: Int?,
    @Json(name = "weather")
    val weather: List<Weather>?,
    @Json(name = "wind_deg")
    val windDeg: Int?,
    @Json(name = "wind_speed")
    val windSpeed: Double?
)