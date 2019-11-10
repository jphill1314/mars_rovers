package com.jphill.marsrovers.latestphotos

import com.jphill.marsrovers.main.injection.scopes.PerFragment
import dagger.Binds
import dagger.Module

@Module
abstract class LatestPhotosModule {

    @Binds
    @PerFragment
    abstract fun bindsFactory(latestPhotosFactory: LatestPhotosFactory): LatestPhotosFactory
}