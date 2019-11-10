package com.jphill.retrofit

import com.jphill.retrofit.models.LatestImagesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MarsRoverImageService {

    @GET("rovers/@{rover}/latest_photos?api_key=DEMO_KEY")
    fun getLatestImages(@Path("rover") roverName: String): Call<LatestImagesResponse>
}