package com.jphill.marsrovers.latestphotos.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jphill.marsrovers.main.injection.qualifiers.MainThreadScheduler
import com.jphill.marsrovers.main.injection.qualifiers.NetworkScheduler
import com.jphill.retrofit.MarsRoverImageService
import io.reactivex.Scheduler
import javax.inject.Inject

class LatestPhotosFactory @Inject constructor(
    private val marsRoverImageService: MarsRoverImageService,
    @NetworkScheduler private val networkScheduler: Scheduler,
    @MainThreadScheduler private val mainThread: Scheduler
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(LatestPhotosViewModel::class.java) ->
                LatestPhotosViewModel(
                    marsRoverImageService,
                    networkScheduler,
                    mainThread
                ) as T
            else -> throw IllegalArgumentException("View model $modelClass not found")
        }
    }
}