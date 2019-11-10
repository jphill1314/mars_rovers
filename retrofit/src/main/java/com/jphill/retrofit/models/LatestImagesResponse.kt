package com.jphill.retrofit.models

import com.google.gson.annotations.SerializedName

data class LatestImagesResponse(
    @SerializedName("latest_photos") val latestPhotos: List<Photo>
)