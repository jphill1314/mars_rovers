package com.jphill.retrofit.models

import com.google.gson.annotations.SerializedName

data class Camera(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("rover_id") val roverId: String,
    @SerializedName("full_name") val fullName: String
)