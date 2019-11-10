package com.jphill.retrofit.models

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("id") val id: Int,
    @SerializedName("sol") val sol: Int,
    @SerializedName("camera") val camera: Camera,
    @SerializedName("img_src") val src: String,
    @SerializedName("earth_date") val earthDate: String,
    @SerializedName("rover") val rover: Rover
)