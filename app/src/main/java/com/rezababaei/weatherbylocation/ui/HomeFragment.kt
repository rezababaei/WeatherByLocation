package com.rezababaei.weatherbylocation.ui

import android.location.Location

import android.view.View
import android.widget.Toast

import androidx.fragment.app.viewModels
import com.google.android.gms.location.*
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.rezababaei.weatherbylocation.R
import com.rezababaei.weatherbylocation.core.BaseFragment
import com.rezababaei.weatherbylocation.databinding.HomeFragmentBinding
import com.rezababaei.weatherbylocation.ui.location.adapter.ViewAdapterLocation
import dagger.hilt.android.AndroidEntryPoint
import java.time.Duration


@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeFragmentBinding, HomeViewModel>(R.layout.home_fragment),
    OnMapReadyCallback {

    override val viewModel: HomeViewModel by viewModels()

    private lateinit var mGoogleMap: GoogleMap

    var mapFrag: SupportMapFragment? = null
    lateinit var mLocationRequest: LocationRequest
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun init() {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())

        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                // Got last known location. In some rare situations this can be null.
                if (location != null) {
//                    viewModel.lat.value=location.latitude.toString()
//                    viewModel.lon.value=location.longitude.toString()
                    Toast.makeText(requireContext(),
                        "Lat: ${location.latitude} Lon: ${location.longitude}",
                        0).show()
                }

            }

        viewModel.lat.value = "35.6892"
        viewModel.lon.value = "51.3890"
        viewModel.getWeather()
        setupMap()
        binding.btnCheckWeather.setOnClickListener {
            val centerLocation = mGoogleMap.cameraPosition.target
            viewModel.lat.value = centerLocation.latitude.toString()
            viewModel.lon.value = centerLocation.longitude.toString()
            viewModel.getWeather()
        }

    }


    private fun setupMap() {
//        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())
        mapFrag = (childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?)
        mapFrag!!.getMapAsync(this)
    }

    override fun observeLiveData() {

        viewModel.weatherResponse.observe(viewLifecycleOwner) { it ->
            if (it != null) {

                binding.recyclerViewDays.adapter = it.daily?.let { it1 -> ViewAdapterLocation(it1) }
                showViewsAfterLoading()
            }
        }

    }

    private fun showViewsAfterLoading() {
        binding.progressBar.visibility = View.GONE
        binding.linearLayoutWeather.visibility = View.VISIBLE
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mGoogleMap = googleMap

    }


    companion object {
        val MY_PERMISSIONS_REQUEST_LOCATION = 99
    }


}