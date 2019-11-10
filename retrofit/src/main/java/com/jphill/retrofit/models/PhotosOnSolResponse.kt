package com.jphill.retrofit.models

import com.google.gson.annotations.SerializedName

data class PhotosOnSolResponse(
    @SerializedName("photos") val photos: List<Photo>
)