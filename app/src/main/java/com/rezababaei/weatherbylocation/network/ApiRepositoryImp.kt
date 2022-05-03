package com.rezababaei.weatherbylocation.network


import com.rezababaei.weatherbylocation.network.datamodel.WeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ApiRepositoryImp @Inject constructor(
    private val apiService: ApiService
) : ApiRepository {

    override suspend fun getWeather(lat:String?, lon:String?, callback: RequestCompleteListener<WeatherResponse>) {
        val call: Call<WeatherResponse> = apiService.getWeather(lat = lat, lon =lon)
        call.enqueue(object : Callback<WeatherResponse> {

            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                if (response.body() != null)
                    callback.onRequestSuccess(response.body()!!)
                else
                    callback.onRequestFailed(response.message()) //let presenter know about failure
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                callback.onRequestFailed(t.localizedMessage!!) //let presenter know about failure
            }
        })
    }



}