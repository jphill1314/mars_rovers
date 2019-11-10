package com.jphill.marsrovers.main.injection

import com.jphill.marsrovers.main.DaggerNavHostFragment
import com.jphill.marsrovers.main.injection.scopes.PerNavHost
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @PerNavHost
    @ContributesAndroidInjector(modules = [FragmentBindingModule::class])
    abstract fun bindsNavHost(): DaggerNavHostFragment
}