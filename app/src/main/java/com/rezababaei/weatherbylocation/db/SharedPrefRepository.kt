package com.rezababaei.weatherbylocation.db

interface SharedPrefRepository {
    fun saveToken(token: String)
    fun getToken(): String?
}