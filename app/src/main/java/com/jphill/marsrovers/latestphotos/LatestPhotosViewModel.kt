package com.jphill.marsrovers.latestphotos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jphill.retrofit.MarsRoverImageService
import com.jphill.retrofit.models.Photo
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable

class LatestPhotosViewModel(
    private val marsRoverImageService: MarsRoverImageService,
    private val networkScheduler: Scheduler,
    private val mainThread: Scheduler
) : ViewModel() {

    private val rover = "curiosity"
    private var sol = 0
    private val disposable = CompositeDisposable()
    private val _photosFromSol = MutableLiveData<List<Photo>>()
    var photosFromSol: LiveData<List<Photo>> = _photosFromSol

    init {
        disposable.add(getRoverAndPhotos())
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

    fun getMorePhotos() = disposable.add(
        marsRoverImageService.getImageFromSol(rover, sol--)
        .subscribeOn(networkScheduler)
        .observeOn(mainThread)
        .subscribe(
            { photos -> updatePhotos(photos.photos) },
            { throwable -> Log.e("LatestPhotosError", "Error loading latest photos", throwable) }
        )
    )

    private fun getRoverAndPhotos() = marsRoverImageService.getRover(rover)
        .map { it.rover.maxSol }
        .switchMap {
            sol = it
            marsRoverImageService.getImageFromSol(rover, sol--)
        }
        .subscribeOn(networkScheduler)
        .observeOn(mainThread)
        .subscribe(
            { photos -> updatePhotos(photos.photos) },
            { throwable -> Log.e("LatestPhotosError", "Error loading latest photos", throwable) }
        )

    private fun updatePhotos(newPhotos: List<Photo>) {
        val newList = mutableListOf<Photo>()
        photosFromSol.value?.let { newList.addAll(it) }
        newList.addAll(newPhotos)
        _photosFromSol.postValue(newList)
    }
}