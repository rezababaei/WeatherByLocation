package com.rezababaei.weatherbylocation.ui

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rezababaei.weatherbylocation.core.BaseViewModel
import com.rezababaei.weatherbylocation.network.ApiRepository
import com.rezababaei.weatherbylocation.network.RequestCompleteListener
import com.rezababaei.weatherbylocation.network.datamodel.WeatherResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val apiRepository: ApiRepository) :
    BaseViewModel() {

    private val _weatherResponse = MutableLiveData<WeatherResponse>()
    val weatherResponse: LiveData<WeatherResponse>
        get() = _weatherResponse

    val lat = MutableLiveData("")
    val lon = MutableLiveData("")

    fun getWeather() {
        viewModelScope.launch {
            val call = apiRepository.getWeather(lat = lat.value, lon = lon.value, object :
                RequestCompleteListener<WeatherResponse> {
                override fun onRequestSuccess(data: WeatherResponse) {
                    _weatherResponse.postValue(data)
                }

                override fun onRequestFailed(errorMessage: String) {
//                    Toast.makeText(this@MainActivity, "Fail to get the data..", Toast.LENGTH_SHORT)
//                        .show()
                }
            })
        }
    }


//    fun saveToken(token: String) {
//        sharedPrefRepository.saveToken(token)
//    }
//


}