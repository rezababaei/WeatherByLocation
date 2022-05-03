package com.rezababaei.weatherbylocation.network.datamodel


import com.squareup.moshi.Json

data class FeelsLike(
    @Json(name = "day")
    val day: Double?,
    @Json(name = "eve")
    val eve: Double?,
    @Json(name = "morn")
    val morn: Double?,
    @Json(name = "night")
    val night: Double?
)