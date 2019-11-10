package com.jphill.retrofit.models

import com.google.gson.annotations.SerializedName

data class LatestPhotosResponse(
    @SerializedName("latest_photos") val latestPhotos: List<Photo>
)