package com.jphill.retrofit.models

import com.google.gson.annotations.SerializedName

data class RoverResponse(
    @SerializedName("rover") val rover: Rover
)