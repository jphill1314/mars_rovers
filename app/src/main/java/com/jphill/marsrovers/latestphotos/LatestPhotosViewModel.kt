package com.jphill.marsrovers.latestphotos

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jphill.retrofit.MarsRoverImageService
import com.jphill.retrofit.models.LatestImagesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LatestPhotosViewModel(marsRoverImageService: MarsRoverImageService) : ViewModel() {

    private val _latestPhotos = MutableLiveData<LatestImagesResponse>()
    val latestPhotos = _latestPhotos

    init {
        marsRoverImageService.getLatestImages("curiosity").enqueue(object : Callback<LatestImagesResponse> {
            override fun onFailure(call: Call<LatestImagesResponse>, t: Throwable) {
                Log.e("LOAD LATEST IMAGES", "FAILURE")
            }

            override fun onResponse(
                call: Call<LatestImagesResponse>,
                response: Response<LatestImagesResponse>
            ) {
                response.body()?.let { _latestPhotos.postValue(it) }
            }
        })
    }
}