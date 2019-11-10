package com.jphill.marsrovers.latestphotos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jphill.retrofit.MarsRoverImageService
import com.jphill.retrofit.models.PhotosOnSolResponse
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable

class LatestPhotosViewModel(
    private val marsRoverImageService: MarsRoverImageService,
    private val networkScheduler: Scheduler,
    private val mainThread: Scheduler
) : ViewModel() {
    private val rover = "curiosity"
    private val disposable = CompositeDisposable()
    private val _photosFromSol = MutableLiveData<PhotosOnSolResponse>()
    var photosFromSol: LiveData<PhotosOnSolResponse> = _photosFromSol

    init {
        disposable.add(getPhotos())
    }

    private fun getPhotos() = marsRoverImageService.getRover(rover)
        .switchMap { marsRoverImageService.getImageFromSol(rover, it.rover.maxSol) }
        .subscribeOn(networkScheduler)
        .observeOn(mainThread)
        .subscribe(
            { photos -> _photosFromSol.postValue(photos) },
            { throwable -> Log.e("LatestPhotosError", "Error loading latest photos", throwable) }
        )
}