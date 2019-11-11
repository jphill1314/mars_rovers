package com.jphill.marsrovers.latestphotos.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jphill.retrofit.MarsRoverImageService
import com.jphill.retrofit.models.Photo
import com.jphill.retrofit.rovers.CuriosityRover
import com.jphill.retrofit.rovers.Rover
import com.jphill.retrofit.rovers.asInt
import com.jphill.retrofit.rovers.toRover
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class LatestPhotosViewModel(
    private val marsRoverImageService: MarsRoverImageService,
    private val networkScheduler: Scheduler,
    private val mainThread: Scheduler
) : ViewModel() {

    var rover: Rover = CuriosityRover()
    private var sol = 0
    var selectedCamera = -1
    private var emptyResults = 0
    private val disposable = CompositeDisposable()
    private val _photosFromSol = MutableLiveData<List<Photo>>()
    var photosFromSol: LiveData<List<Photo>> = _photosFromSol

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

    fun changeRover(newRoverAsInt: Int?) {
        val newRover = newRoverAsInt?.toRover()
        if (newRover != null && newRover.asInt() != rover.asInt()) {
            rover = newRover
            _photosFromSol.value = emptyList()
            selectedCamera = -1
        }
        if (_photosFromSol.value?.size ?: 0 == 0) {
            getRoverAndPhotos()
        }
    }

    fun changeCamera(newCamera: Int) {
        if (newCamera != selectedCamera) {
            selectedCamera = newCamera
            _photosFromSol.value = emptyList()
            getRoverAndPhotos()
        }
    }

    fun getMorePhotos() = disposable.add(
        marsRoverImageService.getImageFromSol(rover.name, getQueryParams())
        .subscribeOn(networkScheduler)
        .observeOn(mainThread)
        .subscribe(
            { photos -> updatePhotos(photos.photos) },
            { throwable -> Log.e(
                "LatestPhotosError",
                "Error loading latest photos for sol $sol",
                throwable
            ) }
        )
    )

    fun getRoverAndPhotos(): Disposable = marsRoverImageService.getRover(rover.name)
        .map { it.rover.maxSol }
        .switchMap {
            sol = it
            marsRoverImageService.getImageFromSol(rover.name, getQueryParams())
        }
        .subscribeOn(networkScheduler)
        .observeOn(mainThread)
        .subscribe(
            { photos -> updatePhotos(photos.photos) },
            { throwable -> Log.e(
                "LatestPhotosError",
                "Error loading rover and latest photos for sol $sol",
                throwable
            ) }
        )

    private fun getQueryParams(): Map<String, String> {
        val params = mutableMapOf<String, String>()

        params["sol"] = (sol--).toString()
        if (selectedCamera >= 0) {
            params["camera"] = rover.cameras[selectedCamera].first
        }

        return params
    }

    private fun updatePhotos(newPhotos: List<Photo>) {
        if (newPhotos.isEmpty()) {
            if (emptyResults++ < 10) {
                getMorePhotos()
            }
        } else {
            emptyResults = 0
            val newList = mutableListOf<Photo>()
            photosFromSol.value?.let { newList.addAll(it) }
            newList.addAll(newPhotos)
            _photosFromSol.postValue(newList)
        }
    }
}