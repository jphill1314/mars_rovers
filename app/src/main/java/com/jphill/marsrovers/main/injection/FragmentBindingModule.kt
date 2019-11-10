package com.jphill.marsrovers.main.injection

import com.jphill.marsrovers.latestphotos.LatestPhotosFragment
import com.jphill.marsrovers.latestphotos.LatestPhotosModule
import com.jphill.marsrovers.main.injection.scopes.PerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @PerFragment
    @ContributesAndroidInjector(modules = [LatestPhotosModule::class])
    abstract fun bindsLatestPhotosFragment(): LatestPhotosFragment
}