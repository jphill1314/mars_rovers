package com.jphill.marsrovers.main.injection

import android.content.Context
import com.jphill.marsrovers.main.MainActivity
import com.jphill.marsrovers.main.injection.scopes.PerActivity
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class MainActivityModule {

    @Binds
    @PerActivity
    abstract fun providesContext(application: MainActivity): Context

    @Module
    companion object {
        @Provides
        @PerActivity
        fun providesResources(context: Context) = context.resources
    }
}