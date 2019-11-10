package com.jphill.marsrovers.latestphotos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jphill.retrofit.MarsRoverImageService
import javax.inject.Inject

class LatestPhotosFactory @Inject constructor(
    private val marsRoverImageService: MarsRoverImageService
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(LatestPhotosViewModel::class.java) -> LatestPhotosViewModel(marsRoverImageService) as T
            else -> throw IllegalArgumentException("View model $modelClass not found")
        }
    }
}