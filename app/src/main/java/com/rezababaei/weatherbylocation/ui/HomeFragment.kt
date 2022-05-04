package com.rezababaei.weatherbylocation.ui

import android.opengl.Visibility
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.rezababaei.weatherbylocation.R
import com.rezababaei.weatherbylocation.core.BaseFragment
import com.rezababaei.weatherbylocation.databinding.HomeFragmentBinding
import com.rezababaei.weatherbylocation.ui.location.adapter.ViewAdapterLocation
import com.rezababaei.weatherbylocation.util.loadImage
import com.rezababaei.weatherbylocation.util.unixTimestampToDateTimeString
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeFragmentBinding, HomeViewModel>(R.layout.home_fragment) {

    override val viewModel: HomeViewModel by viewModels()


    override fun init() {
        viewModel.lat.value = "35.6892"
        viewModel.lon.value = "51.3890"

        viewModel.getWeather()

    }

    override fun observeLiveData() {

        viewModel.weatherResponse.observe(viewLifecycleOwner) { it ->
            val str = StringBuilder()
            if (it != null) {
                val text = "${it.timezone}  ${it.current?.dt?.unixTimestampToDateTimeString()}"

                binding.tvTemp.text = text
                val weatherConditionIconUrl =
                    "http://openweathermap.org/img/w/${it.current?.weather?.get(0)?.icon}.png"
                binding.ivWeather.loadImage(weatherConditionIconUrl)
                binding.tvCondition.text=it.current?.weather?.get(0)?.description

//                binding.recyclerViewDays.layoutManager= LinearLayoutManager(this)
                binding.recyclerViewDays.adapter= it.daily?.let { it1 -> ViewAdapterLocation(it1) }


                showViewsAfterLoading()
            }
        }

    }

    private fun showViewsAfterLoading() {
        binding.progressBar.visibility = View.GONE
        binding.linearLayoutWeather.visibility=View.VISIBLE
    }


}