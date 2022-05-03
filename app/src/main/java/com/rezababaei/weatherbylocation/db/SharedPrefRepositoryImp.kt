package com.rezababaei.weatherbylocation.db

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPrefRepositoryImp @Inject constructor(val sharedPreferences: SharedPreferences) :
    SharedPrefRepository {

    companion object {
        val TOKEN_KEY = "token"
    }

    override fun saveToken(token: String) {
        saveString(TOKEN_KEY, token)
    }

    override fun getToken(): String? {
       return loadString(TOKEN_KEY)
    }

    private fun saveString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    private fun loadString(key: String) =
        sharedPreferences.getString(key, "")

}