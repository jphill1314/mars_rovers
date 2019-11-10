package com.jphill.retrofit

import com.jphill.retrofit.models.PhotosOnSolResponse
import com.jphill.retrofit.models.LatestPhotosResponse
import com.jphill.retrofit.models.RoverResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarsRoverImageService {

    @GET("rovers/{rover}")
    fun getRover(@Path("rover") roverName: String): Observable<RoverResponse>

    @GET("rovers/{rover}/latest_photos")
    fun getLatestImages(@Path("rover") roverName: String): Observable<LatestPhotosResponse>

    @GET("rovers/{rover}/photos")
    fun getImageFromSol(@Path("rover") roverName: String, @Query("sol") sol: Int): Observable<PhotosOnSolResponse>
}