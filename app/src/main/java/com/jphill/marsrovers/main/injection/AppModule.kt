package com.jphill.marsrovers.main.injection

import android.app.Application
import android.content.Context
import com.jphill.marsrovers.MainActivity
import com.jphill.marsrovers.main.injection.scopes.MainActivityModule
import com.jphill.marsrovers.main.injection.scopes.PerActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun providesMainActivity(): MainActivity

    @Binds
    @PerActivity
    abstract fun providesContext(application: Application): Context

    @Module
    companion object {
        @Provides
        @PerActivity
        fun providesResources(context: Context) = context.resources
    }
}